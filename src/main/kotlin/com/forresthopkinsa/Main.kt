package com.forresthopkinsa

import com.forresthopkinsa.model.FullMessageNode
import java.text.DateFormat
import java.util.*

fun main(args: Array<String>) {
	val request = Config.request
	
	val response = Handler(request).apply { send() }.response!!
	
	val messages = response.data.messageThread.messagePage.messages
	
	messages.forEach(::messagePrinter)
}

fun messagePrinter(message: FullMessageNode) {
	val sender: String = when (message.messageSender.id) {
		Config.myId ->  "Forrest"
		Config.herId -> "Serena "
		else -> "???????"
	}
	
	val time = Date(message.timestampPrecise.toLong())
	val date = DateFormat.getDateTimeInstance().format(time)
	
	val text = message.message.text
	
	println("($date) $sender: $text")
}