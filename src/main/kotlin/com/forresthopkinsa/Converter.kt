package com.forresthopkinsa

import com.forresthopkinsa.model.Actor
import com.forresthopkinsa.model.dto.AttachmentType.*
import com.forresthopkinsa.model.dto.FullMessageNode
import com.forresthopkinsa.model.dto.MessageSender
import com.forresthopkinsa.model.message.Media
import com.forresthopkinsa.model.message.Message
import com.forresthopkinsa.model.message.Sticker
import com.forresthopkinsa.model.message.Text
import java.util.*

object Converter {
	
	fun toMessage(node: FullMessageNode): Message = when {
		node.sticker != null -> toSticker(node)
		node.message.text.isNotEmpty() -> toText(node)
		node.blobAttachments.isNotEmpty() -> toMedia(node)
		else -> throw IllegalArgumentException(gson.toJson(node))
	}
	
	private fun toMedia(node: FullMessageNode): Message = when(node.blobAttachments[0].type) {
		IMAGE -> toImage(node)
		GIF -> toGif(node)
	}
	
	private fun toText(node: FullMessageNode) = Text(node.message.text, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toSticker(node: FullMessageNode) = Sticker(node.sticker!!.url, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toImage(node: FullMessageNode) = Media(node.blobAttachments[0].preview!!.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toGif(node: FullMessageNode) = Media(node.blobAttachments[0].gifPreview!!.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun String.toDate() = Date(toLong())
	
	private fun MessageSender.toActor() = Actor(id, getName(id))
	
}