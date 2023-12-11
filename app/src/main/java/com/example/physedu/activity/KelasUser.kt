package com.example.physedu.activity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KelasUser (
    val kelas: String,
    val mulai : String,
    val gambar: Int
): Parcelable