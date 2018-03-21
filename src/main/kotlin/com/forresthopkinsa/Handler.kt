package com.forresthopkinsa

import com.forresthopkinsa.model.dto.Response
import com.forresthopkinsa.model.dto.ResponseContainer
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class Handler(private val request: Request) {
	
	private var okResp: okhttp3.Response? = null
	
	private var json: String? = null
	
	private val client = OkHttpClient.Builder()
			.connectTimeout(25, TimeUnit.SECONDS)
			.readTimeout(25, TimeUnit.SECONDS)
			.writeTimeout(25, TimeUnit.SECONDS)
			.build()
	
	fun send(): Boolean {
		okResp = client.newCall(request.okHttpRequest).execute()
		
		json = okResp?.body()?.string()?.dropLast(79)
		
		println(json)
		
		return okResp?.isSuccessful == true
	}
	
	val response: Response?
		get() = gson.fromJson(json, ResponseContainer::class.java).response
	
}