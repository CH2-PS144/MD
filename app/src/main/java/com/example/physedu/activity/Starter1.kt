package com.example.physedu.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.Button
import com.example.physedu.R

class Starter1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)
        window?.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        supportActionBar?.hide()

        val btnLewati: Button = findViewById(R.id.btn_lewati)
        val btnLanjut: Button = findViewById(R.id.btn_lanjut)

        btnLewati.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnLanjut.setOnClickListener {
            startActivity(Intent(this, Starter2::class.java))
            finish()
        }

    }
}