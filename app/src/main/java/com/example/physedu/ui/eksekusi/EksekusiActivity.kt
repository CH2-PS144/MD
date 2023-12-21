package com.example.physedu.ui.eksekusi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.physedu.databinding.ActivityEksekusiBinding

class EksekusiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEksekusiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEksekusiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvQuest.text = intent.getStringExtra(EXTRA_QUESTION)
        binding.tvResult.text = intent.getStringExtra(EXTRA_RESULT)
    }

    companion object {
         const val EXTRA_QUESTION = "extra_question"
         const val EXTRA_RESULT = "extra_result"
    }
}
