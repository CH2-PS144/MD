package com.example.physedu.ui.kelas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KelasUser (
    var kelas: String = " ",
    var mulai : String = " ",
    var gambar: Int = 0
): Parcelable