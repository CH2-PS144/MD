package com.example.physedu


import androidx.lifecycle.liveData
import com.example.physedu.response.UploadResponse
import com.example.physedu.retrofit.ApiService
import com.google.gson.Gson
import okhttp3.MultipartBody
import retrofit2.HttpException
import java.io.IOException

class UserRepository private constructor(
    private val apiService: ApiService,
) {
    suspend fun uploadGambar(file: MultipartBody.Part) = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.uploadGambar(file)
            emit(Result.Success(response))
        } catch (e: HttpException) {
            val jsonInString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonInString, UploadResponse::class.java)
            emit(Result.Error(errorBody?.result ?: "Unknown error"))
        } catch (e: IOException) {
            emit(Result.Error("Network error"))
        } catch (e: Exception) {
            emit(Result.Error("An error occurred"))
        }
    }


    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService)
            }.also { instance = it }
    }
}