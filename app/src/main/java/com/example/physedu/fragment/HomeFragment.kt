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
import com.example.physedu.activity.KelasUser
import com.example.physedu.adapter.KelasUserAdapter
import com.example.physedu.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var rvkelasUser: RecyclerView
    private val list = ArrayList<KelasUser>()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        list.addAll(getListKelas())
////        showRecyclerList()
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvkelasUser = view.findViewById(R.id.rv_kelasUser) ?: throw IllegalStateException("RecyclerView not found")

        rvkelasUser.setHasFixedSize(true)
        list.addAll(getListKelas())

        showRecyclerList()
        return view
    }

    private fun getListKelas(): ArrayList<KelasUser> {
        val dataKelas = resources.getStringArray(R.array.kelas)
        val dataMulai = resources.getStringArray(R.array.mulai)
        val dataGambar = resources.obtainTypedArray(R.array.gambar)
        val listKelas = ArrayList<KelasUser>()
        for (i in dataKelas.indices) {
            val kelas = KelasUser(dataKelas[i], dataMulai[i], dataGambar.getResourceId(i, -1))
            listKelas.add(kelas)
        }
        return listKelas
    }

    private fun showRecyclerList() {
        rvkelasUser.layoutManager = LinearLayoutManager(this.context)
        val listKelasAdapter = KelasUserAdapter(list)
        rvkelasUser.adapter = listKelasAdapter
//
//        listHeroAdapter.setOnItemClickCallback(object : KelasUserAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: KelasUser) {
//                showSelectedCabai(data)
//            }
//        })
    }

}