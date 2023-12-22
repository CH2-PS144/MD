package com.example.physedu.data

import android.content.Context
import com.example.physedu.data.repos.UserRepository
import com.example.physedu.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(apiService)
    }
}