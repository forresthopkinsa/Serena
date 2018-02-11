package com.forresthopkinsa.model.message

import com.forresthopkinsa.model.Actor
import java.util.*

data class Sticker(
		override val imageUrl: String,
		override val time: Date,
		override val sender: Actor
) : Media(imageUrl, time, sender)