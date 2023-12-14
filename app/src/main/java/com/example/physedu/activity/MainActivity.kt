package com.example.physedu.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.physedu.R
import com.example.physedu.fragment.AboutFragment
import com.example.physedu.fragment.HomeFragment
import com.example.physedu.fragment.KameraFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val cameraFragment = KameraFragment()
        val aboutFragment = AboutFragment()

        makeCurrentFragment(homeFragment)
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.nav_view)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_kamera -> {
                    startActivity(Intent(this, MainActivityCamera::class.java))
                    finish()
//                    makeCurrentFragment(cameraFragment)
                }
                R.id.navigation_about -> makeCurrentFragment(aboutFragment)
            }
            true
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