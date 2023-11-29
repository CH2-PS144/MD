package com.example.physedu.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import com.example.physedu.R
import com.example.physedu.databinding.ActivityCameraBinding

class Camera : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}