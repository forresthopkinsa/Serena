package com.forresthopkinsa

import com.forresthopkinsa.model.dto.RequestContainer
import okhttp3.FormBody
import okhttp3.Request

data class Request(
		val dtsg: String,
		val c_user: String,
		val xs: String,
		val query: RequestContainer
) {
	
	private val form = FormBody.Builder()
			.add("fb_dtsg", dtsg)
			.add("queries", gson.toJson(query))
			.build()
	
	val okHttpRequest = Request.Builder()
			.url("https://www.facebook.com/api/graphqlbatch/")
			.post(form)
			.addHeader("Cookie", "c_user=$c_user; xs=$xs")
			.addHeader("Cache-Control", "no-cache")
			.build()!!
	
	
}