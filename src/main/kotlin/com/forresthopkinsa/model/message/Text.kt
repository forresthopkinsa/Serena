package com.forresthopkinsa.model.message

import com.forresthopkinsa.model.Actor
import java.util.*

data class Text(
		override val text: String,
		override val time: Date,
		override val sender: Actor
) : Message {
	override val imageUrl: String? = null
	override val type: MessageType = MessageType.IMAGE
}