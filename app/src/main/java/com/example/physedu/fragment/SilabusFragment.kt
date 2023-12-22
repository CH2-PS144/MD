package com.example.physedu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.physedu.R
import com.example.physedu.adapter.MateriUserAdapter
import com.example.physedu.data.`object`.SilabusObject
import com.example.physedu.ui.kelas.MateriUser
import com.example.physedu.ui.materi.MateriBesaranActivity

class SilabusFragment : Fragment() {

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
        const val ARG_NAME = "app_name"
    }

    private lateinit var rvListMateri: RecyclerView
    private var list: ArrayList<MateriUser> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_silabus, container, false)
        rvListMateri = view.findViewById(R.id.rv_listmateri)
        rvListMateri.setHasFixedSize(true)

        if (list.isEmpty()) {
            list.addAll(SilabusObject.listDataMateri)
            showRecyclerList()
        } else {
            showRecyclerList()
        }

        return view
    }
    private fun showRecyclerList() {
        rvListMateri.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = MateriUserAdapter(list)
        rvListMateri.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : MateriUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: MateriUser) {
                showSelectedKelas(data)
            }
        })
    }

    private fun showSelectedKelas(pilihmateri: MateriUser) {
        Toast.makeText(context, "Kamu memilih " + pilihmateri.nama, Toast.LENGTH_SHORT).show()
        val moveWithObjectIntent = Intent(context, MateriBesaranActivity::class.java)
        startActivity(moveWithObjectIntent)
    }

}