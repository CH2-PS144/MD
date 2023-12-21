package com.example.physedu.data.response

import com.google.gson.annotations.SerializedName

data class UploadResponse(

	@field:SerializedName("result")
	val result: String,

	@field:SerializedName("question")
	val question: String
)
