package com.forresthopkinsa

import com.forresthopkinsa.model.Query
import com.forresthopkinsa.model.QueryParams
import com.forresthopkinsa.model.RequestContainer
import com.forresthopkinsa.model.ResponseContainer
import com.typesafe.config.ConfigFactory
import okhttp3.OkHttpClient
import java.util.*


fun main(args: Array<String>) {
	Main().request()
}


class Main {
	
	val config = ConfigFactory.defaultApplication()
	
	val dtsg = config.getString("dtsg")
	val c_user = config.getString("c_user")
	val xs = config.getString("xs")
	
	val docId = "1508526735892416"
	val serenaId = "100000746827681"
	
	fun request() {
		
		val query = RequestContainer(Query(docId, QueryParams(serenaId, 15)))
		
		val request = Request(dtsg, c_user, xs, query)
		
		val response = OkHttpClient().newCall(request.okHttpRequest).execute()
		
		println(response.message())
		
		val json = response.body()?.string()?.dropLast(79)
		
		println(json)
		
		val obj = gson.fromJson(json, ResponseContainer::class.java)
		
		val messages = obj.response.data.messageThread.messagePage.messages
		
		messages.forEach { println(it.messageSender.id + " : " + Date(it.timestampPrecise.toLong()) + " : " + it.message.text) }
		
		
	}
	
}