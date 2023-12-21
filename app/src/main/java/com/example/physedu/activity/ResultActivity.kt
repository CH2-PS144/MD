package com.example.physedu.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.physedu.EksekusiActivity
import com.example.physedu.R
import com.example.physedu.ViewModelFactory
import com.example.physedu.databinding.ActivityResultBinding
import com.example.physedu.response.UploadResponse
import com.example.physedu.uriToFile
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private var currentImageUri: Uri? = null
    private lateinit var resultViewModel: ResultViewModel
    private val response = UploadResponse()


    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission request granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Permission request denied", Toast.LENGTH_LONG).show()
            }
        }

    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        resultViewModel = ViewModelProvider(this, factory)[ResultViewModel::class.java]

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle("Halaman Utama")
        }
        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (!allPermissionsGranted()) {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
        binding.hasilButton.setOnClickListener{uploadImage()}

        val imageUriString = intent.getStringExtra("IMAGE_URI")
        val imageUri = Uri.parse(imageUriString)

        // Tampilkan gambar menggunakan Glide
        Glide.with(this)
            .load(imageUri)
            .placeholder(R.drawable.ic_place_holder) // Gambar placeholder jika URI kosong
            .error(R.drawable.ic_place_holder) // Gambar error jika terjadi kesalahan
            .into(binding.previewImageView)
    }

    @SuppressLint("NewApi")
    private fun uploadImage() {
        currentImageUri = intent.getStringExtra("IMAGE_URI")?.toUri()
        currentImageUri?.let { uri ->
            val imageFile = uriToFile(uri, this)
            Log.d("Image File", "showImage: ${imageFile.path}")
            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
            val multipartBody = MultipartBody.Part.createFormData(
                "image",
                imageFile.name,
                requestImageFile
            )

            lifecycleScope.launch {
                resultViewModel.uploadGambar(multipartBody).observe(this@ResultActivity) {
                    RESULT = response.result.toString()
                    QUESTION = response.question.toString()
                    val intent =
                        Intent(this@ResultActivity, EksekusiActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
//                    when (it) {
//                        is Result.Success -> {
//
////                            AlertDialog.Builder(this@ResultActivity).apply {
////                                setTitle("Success")
////                                setMessage("Story created")
////                                setPositiveButton("Continue") { _, _ ->
////
////                                }
////                                create()
////                                show()
////                            }
//                        }
//
//                        is Result.Loading -> {
//
//                        }
//
//                        is Result.Error -> {
//
//                        }
//
//                        else -> {}
//                    }
                }
            }
        }?: showToast(getString(R.string.empty_image_warning))
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
        var RESULT = "RESULT"
        var QUESTION = "QUESTION"
    }
}