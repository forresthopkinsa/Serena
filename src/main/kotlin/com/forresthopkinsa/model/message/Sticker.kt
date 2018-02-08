package com.forresthopkinsa.model.message

import com.forresthopkinsa.model.Actor
import java.util.*

class Sticker(
		override val imageUrl: String,
		override val time: Date,
		override val sender: Actor
) : Message {
	override val text: String? = null
	override val type: MessageType = MessageType.IMAGE
}