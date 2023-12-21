package com.example.physedu.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.physedu.R
import com.example.physedu.databinding.ActivityMainBinding
import com.example.physedu.fragment.AboutFragment
import com.example.physedu.fragment.HomeFragment
import com.example.physedu.ui.camera.CameraActivity
import com.example.physedu.ui.result.ResultActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val aboutFragment = AboutFragment()

        makeCurrentFragment(homeFragment)
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> makeCurrentFragment(homeFragment)
                R.id.nav_camera -> {
                    val intent = Intent(this, CameraActivity::class.java)
                    launcherIntentCameraX.launch(intent)
                }
                R.id.nav_about -> makeCurrentFragment(aboutFragment)
            }
            true
        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CameraActivity.CAMERAX_RESULT) {
            currentImageUri = it.data?.getStringExtra(CameraActivity.EXTRA_CAMERAX_IMAGE)?.toUri()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("IMAGE_URI", currentImageUri.toString())
            startActivity(intent)
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}