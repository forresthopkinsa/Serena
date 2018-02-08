package com.forresthopkinsa

import com.forresthopkinsa.model.dto.*
import okhttp3.OkHttpClient

class Handler(private val request: Request) {
	
	private var okResp: okhttp3.Response? = null
	
	private var json: String? = null
	
	fun send(): Boolean {
		okResp = OkHttpClient().newCall(request.okHttpRequest).execute()
		
		json = okResp?.body()?.string()?.dropLast(79)
		
		println(json)
		
		return okResp?.isSuccessful == true
	}
	
	val response: Response?
		get() = gson.fromJson(json, ResponseContainer::class.java).response
	
}