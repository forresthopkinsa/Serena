package com.forresthopkinsa.model.message

import java.util.*

data class Image(
		override val imageUrl: String,
		override val time: Date
) : Message {
	override val text: String? = null
	override val type: MessageType = MessageType.IMAGE
}