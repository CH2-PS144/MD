package com.example.physedu.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import com.example.physedu.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this, Starter1::class.java))
            finish()
        }, 3000)
    }
}