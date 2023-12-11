package com.example.physedu.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.physedu.R
import com.example.physedu.activity.ClassObject
import com.example.physedu.activity.KelasUser
import com.example.physedu.adapter.KelasUserAdapter
import com.example.physedu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var rvKelasUser: RecyclerView
    private var list: ArrayList<KelasUser> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvKelasUser = view.findViewById(R.id.rv_kelasUser)
        rvKelasUser.setHasFixedSize(true)

        list.addAll(ClassObject.listDataKelas)
        showRecyclerList()

        return view
    }

    private fun showRecyclerList() {
        rvKelasUser.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = KelasUserAdapter(list)
        rvKelasUser.adapter = listHeroAdapter
    }
}