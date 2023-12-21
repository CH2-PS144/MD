package com.example.physedu.activity

import androidx.lifecycle.ViewModel
import com.example.physedu.UserRepository
import okhttp3.MultipartBody

class ResultViewModel(private val repository: UserRepository) : ViewModel() {
    suspend fun uploadGambar(file: MultipartBody.Part) = repository.uploadGambar(file)
}