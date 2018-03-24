package com.forresthopkinsa

import com.forresthopkinsa.model.Actor
import com.forresthopkinsa.model.dto.AttachmentType.*
import com.forresthopkinsa.model.dto.FullMessageNode
import com.forresthopkinsa.model.dto.MessageSender
import com.forresthopkinsa.model.dto.MessageType
import com.forresthopkinsa.model.message.Media
import com.forresthopkinsa.model.message.Message
import com.forresthopkinsa.model.message.Sticker
import com.forresthopkinsa.model.message.Text
import java.util.*

object Converter {
	
	private const val AUDIO_IMAGE = "https://www.iconsdb.com/icons/download/black/audio-file-16.png"
	
	fun toMessage(node: FullMessageNode): Message = when {
		node.type == MessageType.VOICECALL || node.type == MessageType.VIDEOCALL -> toCall(node)
		node.sticker != null -> toSticker(node)
		node.message?.text?.isNotEmpty() ?: false -> toText(node)
		node.blobAttachments?.isNotEmpty() ?: false -> toMedia(node)
		node.extensibleAttachment != null -> toExtensible(node)
		else -> throw IllegalArgumentException(gson.toJson(node))
	}
	
	private fun toMedia(node: FullMessageNode): Message = when (node.blobAttachments!![0].type) {
		IMAGE -> toImage(node)
		GIF -> toGif(node)
		VIDEO -> toVideo(node)
		AUDIO -> toAudio(node)
		FILE -> toFile(node)
	}
	
	private fun toExtensible(node: FullMessageNode) = when {
		
		node.extensibleAttachment!!.story.media?.image != null ->
			Media(node.extensibleAttachment.story.media!!.image.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
		
		node.extensibleAttachment.story.description?.content != null ->
			Text(node.extensibleAttachment.story.description.content, node.timestampPrecise.toDate(), node.messageSender.toActor())
		
		else -> throw IllegalArgumentException(gson.toJson(node))
	}
	
	private fun toText(node: FullMessageNode) = Text(node.message!!.text, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toSticker(node: FullMessageNode) = Sticker(node.sticker!!.url, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toImage(node: FullMessageNode) = Media(node.blobAttachments!![0].preview!!.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toGif(node: FullMessageNode) = Media(node.blobAttachments!![0].gifPreview!!.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toVideo(node: FullMessageNode) = Media(node.blobAttachments!![0].videoPreviewSmall!!.uri, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toAudio(node: FullMessageNode) = Media(AUDIO_IMAGE, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toFile(node: FullMessageNode) = Text(node.blobAttachments!![0].fileName, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun toCall(node: FullMessageNode) = Text(node.callSnippet!!, node.timestampPrecise.toDate(), node.messageSender.toActor())
	
	private fun String.toDate() = Date(toLong())
	
	private fun MessageSender.toActor() = Actor(id, getName(id))
	
}