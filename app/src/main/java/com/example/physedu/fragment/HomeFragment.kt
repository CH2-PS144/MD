package com.example.physedu.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.physedu.R
import com.example.physedu.activity.KelasActivity
import com.example.physedu.`object`.ClassObject
import com.example.physedu.activity.KelasUser
import com.example.physedu.adapter.KelasUserAdapter

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

        if (list.isEmpty()) {
            list.addAll(ClassObject.listDataKelas)
            showRecyclerList()
        }else{
            showRecyclerList()
        }
        return view
    }

    private fun showRecyclerList() {
        rvKelasUser.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = KelasUserAdapter(list)
        rvKelasUser.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : KelasUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KelasUser) {
                showSelectedKelas(data)
            }
        })
    }

    private fun showSelectedKelas(pilihkelas: KelasUser) {
        Toast.makeText(context, "Kamu memilih " + pilihkelas.kelas, Toast.LENGTH_SHORT).show()
        val moveWithObjectIntent = Intent(context, KelasActivity::class.java)
        startActivity(moveWithObjectIntent)
    }
}