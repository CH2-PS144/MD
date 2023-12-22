package com.example.physedu.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.physedu.fragment.SilabusFragment

class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity)  {
    var appName: String= "hallo"
    override fun createFragment(position: Int): Fragment {
        val fragment = SilabusFragment()
        fragment.arguments = Bundle().apply {
            putInt(SilabusFragment.ARG_SECTION_NUMBER, position + 1)
            putString(SilabusFragment.ARG_NAME,appName)
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 1
    }


}