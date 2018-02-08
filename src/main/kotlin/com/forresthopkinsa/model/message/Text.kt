package com.forresthopkinsa.model.message

import java.util.*

data class Text(
		override val text: String,
		override val time: Date
) : Message {
	override val imageUrl: String? = null
	override val type: MessageType = MessageType.IMAGE
}