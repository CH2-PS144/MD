package com.example.physedu.ui.result

import androidx.lifecycle.ViewModel
import com.example.physedu.data.repos.UserRepository
import okhttp3.MultipartBody

class ResultViewModel(private val repository: UserRepository) : ViewModel() {
    suspend fun uploadGambar(file: MultipartBody.Part) = repository.uploadGambar(file)
}