package com.forresthopkinsa

import com.forresthopkinsa.model.Response
import com.forresthopkinsa.model.ResponseContainer
import okhttp3.OkHttpClient

class Handler(private val request: Request) {
	
	private var okResp: okhttp3.Response? = null
	
	private val json: String?
		get() = okResp?.body()?.string()?.dropLast(79)
	
	fun send(): Boolean {
		okResp = OkHttpClient().newCall(request.okHttpRequest).execute()
		return okResp?.isSuccessful == true
	}
	
	val response: Response?
		get() = gson.fromJson(json, ResponseContainer::class.java).response
	
}