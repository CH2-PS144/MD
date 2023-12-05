package com.example.physedu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.physedu.R
import com.example.physedu.activity.KelasUser
import com.example.physedu.activity.KelasUserAdapter

class HomeFragment : Fragment() {
    private lateinit var rvkelasUser: RecyclerView
    private val list = ArrayList<KelasUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rvkelasUser = view?.findViewById(R.id.rv_kelasUser)!!
        rvkelasUser.layoutManager = LinearLayoutManager(context)
        rvkelasUser.setHasFixedSize(true)


        list.addAll(getListKelas())
        showRecyclerList()
    }

    private fun getListKelas(): ArrayList<KelasUser> {
        val dataKelas = resources.getStringArray(R.array.kelas)
        val dataGambar = resources.obtainTypedArray(R.array.gambar)
        val listCabai = ArrayList<KelasUser>()
        for (i in dataKelas.indices) {
            val cabai = KelasUser(dataKelas[i], dataGambar.getResourceId(i, -1))
            listCabai.add(cabai)
        }
        return listCabai
    }

    private fun showRecyclerList() {
        rvkelasUser.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = KelasUserAdapter(list)
        rvkelasUser.adapter = listHeroAdapter
//
//        listHeroAdapter.setOnItemClickCallback(object : KelasUserAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: KelasUser) {
//                showSelectedCabai(data)
//            }
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }
}