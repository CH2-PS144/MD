package com.example.physedu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.physedu.activity.ResultActivity.Companion.QUESTION
import com.example.physedu.activity.ResultActivity.Companion.RESULT
import com.example.physedu.databinding.ActivityEksekusiBinding

class EksekusiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEksekusiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEksekusiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hasilSoal.text = QUESTION
        binding.hasilJawaban.text = RESULT
    }
}