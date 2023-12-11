package com.example.physedu.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.physedu.R
import com.example.physedu.databinding.ActivityMainBinding
import com.example.physedu.fragment.AboutFragment
import com.example.physedu.fragment.HomeFragment
import com.example.physedu.fragment.KameraFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_kamera -> {
                    replaceFragment(KameraFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_about -> {
                    replaceFragment(AboutFragment())
                    return@setOnItemSelectedListener true
                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }

}