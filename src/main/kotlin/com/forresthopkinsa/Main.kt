package com.forresthopkinsa

import com.forresthopkinsa.model.dto.FullMessageNode
import com.forresthopkinsa.render.HelloPdf
import java.text.DateFormat

fun main(args: Array<String>) {
	
	val pdf = HelloPdf()
	
	val request = Config.request
	
	val response = Handler(request).apply { send() }.response!!
	
	val messages = response.data.messageThread.messagePage.messages
	
	messages.forEach { messagePrinter(it, pdf) }
	
	pdf.close()
}

fun messagePrinter(message: FullMessageNode, pdf: HelloPdf) {
	val msg = Converter.toMessage(message)
	
	val sender = msg.sender.name
	
	val date = DateFormat.getDateTimeInstance().format(msg.time)
	
	val text = msg.text ?: msg.imageUrl ?: "<<<NULL>>>"
	
	println("($date) $sender: $text")
	
	pdf.append(msg)
	
}