package com.example.physedu.response

import com.google.gson.annotations.SerializedName

data class UploadResponse(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("question")
	val question: String? = null
)
