package com.forresthopkinsa

import com.forresthopkinsa.model.message.*
import com.forresthopkinsa.model.dto.FullMessageNode
import java.util.*

object Converter {
	
	fun toMessage(node: FullMessageNode): Message {
		return when {
			node.sticker != null -> toSticker(node)
			node.message.text.isNotEmpty() -> toText(node)
			node.blobAttachments.isNotEmpty() -> toImage(node)
			else -> throw IllegalArgumentException(gson.toJson(node))
		}
	}
	
	fun toText(node: FullMessageNode) = Text(node.message.text, node.timestampPrecise.toDate())
	
	fun toSticker(node: FullMessageNode) = Sticker(node.sticker!!.url, node.timestampPrecise.toDate())
	
	fun toImage(node: FullMessageNode) = Image(node.blobAttachments[0].preview!!.uri, node.timestampPrecise.toDate())
	
	private fun String.toDate() = Date(toLong())
	
}