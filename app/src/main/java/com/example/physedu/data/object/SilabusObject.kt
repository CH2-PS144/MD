package com.example.physedu.data.`object`

import com.example.physedu.R
import com.example.physedu.ui.kelas.MateriUser

object SilabusObject {
    private val nameClass = arrayOf(
        "Besaran & Pengukuran",
        "Zat & Perubahan",
        "Suhu Kalor & Pemuaian"
    )

    private val textMulai = arrayOf(
        "Mulai",
        "Mulai",
        "Mulai"
    )

    private val avatar = intArrayOf(
        R.drawable.circle_number_1,
        R.drawable.circle_number_2,
        R.drawable.circle_number_3
    )

    val listDataMateri: ArrayList<MateriUser>
        get() {
            val list = arrayListOf<MateriUser>()
            for (position in nameClass.indices) {
                val grade = MateriUser()
                grade.nama = nameClass[position]
                grade.mulai = textMulai[position]
                grade.gambar = avatar[position]
                list.add(grade)
            }
            return list
        }

}