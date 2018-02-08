package com.forresthopkinsa.model.message

import java.util.*

class Sticker(
		override val imageUrl: String,
		override val time: Date
) : Message {
	override val text: String? = null
	override val type: MessageType = MessageType.IMAGE
}