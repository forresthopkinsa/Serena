package com.forresthopkinsa.model.message

import com.forresthopkinsa.model.Actor
import java.util.*

interface Message {
	
	val time: Date
	val text: String?
	val imageUrl: String?
	val type: MessageType
	val sender: Actor
	
}