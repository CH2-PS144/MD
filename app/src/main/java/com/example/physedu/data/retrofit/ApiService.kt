package com.example.physedu.data.retrofit

import com.example.physedu.data.response.UploadResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("predict")
    suspend fun uploadGambar(
        @Part file: MultipartBody.Part,
    ): UploadResponse

//    @POST("predict")
//    suspend fun uploadGambar(
//        @Field("image") image: Image
//    ): UploadResponse
}