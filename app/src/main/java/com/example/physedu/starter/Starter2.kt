package com.example.physedu.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.example.physedu.R

class Starter2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter2)
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        val btnKembali: Button = findViewById(R.id.Str2btn_kembali)
        val btnLanjut: Button = findViewById(R.id.Str2btn_lanjut)

        btnKembali.setOnClickListener {
            startActivity(Intent(this, Starter1::class.java))
            finish()
        }

        btnLanjut.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}