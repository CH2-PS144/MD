package com.example.physedu.`object`

import com.example.physedu.R
import com.example.physedu.activity.KelasUser

object ClassObject {

    private val nameClass = arrayOf(
        "KELAS VII",
        "KELAS VIII",
        "KELAS IX"
    )

    private val textMulai = arrayOf(
        "Ayo Mulai",
        "Ayo Mulai",
        "Ayo Mulai"
    )

    private val avatar = intArrayOf(
        R.drawable.icon_kelas_1,
        R.drawable.icon_kelas_2,
        R.drawable.icon_kelas_3
    )

    val listDataKelas: ArrayList<KelasUser>
        get() {
            val list = arrayListOf<KelasUser>()
            for (position in nameClass.indices ) {
                val grade = KelasUser()
                grade.kelas = nameClass[position]
                grade.mulai = textMulai[position]
                grade.gambar = avatar[position]
                list.add(grade)
            }
            return list
        }
}