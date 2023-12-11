package com.example.physedu.activity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KelasUser (
    var kelas: String = " ",
    var mulai : String = " ",
    var gambar: Int = 0
): Parcelable