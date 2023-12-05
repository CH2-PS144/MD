package com.example.physedu.activity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KelasUser (
    val namaKelas: String,
    val gambar: Int
): Parcelable