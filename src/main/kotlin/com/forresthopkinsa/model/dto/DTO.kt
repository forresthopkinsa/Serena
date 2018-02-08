package com.forresthopkinsa.model.dto

import com.google.gson.annotations.SerializedName

data class ResponseContainer(
		@SerializedName("o0") val response: Response
)

data class Response(
		@SerializedName("data") val data: Data
)

data class Data(
		@SerializedName("message_thread") val messageThread: MessageThread
)

data class MessageThread(
		@SerializedName("thread_key") val threadKey: ThreadKey,
		@SerializedName("name") val name: Any,
		@SerializedName("last_message") val lastMessage: LastMessage,
		@SerializedName("unread_count") val unreadCount: Int,
		@SerializedName("messages_count") val messagesCount: Int,
		@SerializedName("image") val image: Any,
		@SerializedName("updated_time_precise") val updatedTimePrecise: String,
		@SerializedName("mute_until") val muteUntil: Any,
		@SerializedName("is_pin_protected") val isPinProtected: Boolean,
		@SerializedName("is_viewer_subscribed") val isViewerSubscribed: Boolean,
		@SerializedName("thread_queue_enabled") val threadQueueEnabled: Boolean,
		@SerializedName("folder") val folder: String,
		@SerializedName("has_viewer_archived") val hasViewerArchived: Boolean,
		@SerializedName("is_page_follow_up") val isPageFollowUp: Boolean,
		@SerializedName("cannot_reply_reason") val cannotReplyReason: Any,
		@SerializedName("ephemeral_ttl_mode") val ephemeralTtlMode: Int,
		@SerializedName("customization_info") val customizationInfo: CustomizationInfo,
		@SerializedName("thread_admins") val threadAdmins: List<Any>,
		@SerializedName("approval_mode") val approvalMode: Any,
		@SerializedName("joinable_mode") val joinableMode: JoinableMode,
		@SerializedName("thread_queue_metadata") val threadQueueMetadata: Any,
		@SerializedName("event_reminders") val eventReminders: EventReminders,
		@SerializedName("montage_thread") val montageThread: Any,
		@SerializedName("last_read_receipt") val lastReadReceipt: LastReadReceipt,
		@SerializedName("related_page_thread") val relatedPageThread: Any,
		@SerializedName("rtc_call_data") val rtcCallData: RtcCallData,
		@SerializedName("associated_object") val associatedObject: Any,
		@SerializedName("privacy_mode") val privacyMode: Int,
		@SerializedName("reactions_mute_mode") val reactionsMuteMode: String,
		@SerializedName("mentions_mute_mode") val mentionsMuteMode: String,
		@SerializedName("customization_enabled") val customizationEnabled: Boolean,
		@SerializedName("thread_type") val threadType: String,
		@SerializedName("participant_add_mode_as_string") val participantAddModeAsString: Any,
		@SerializedName("is_canonical_neo_user") val isCanonicalNeoUser: Boolean,
		@SerializedName("participants_event_status") val participantsEventStatus: List<Any>,
		@SerializedName("page_comm_item") val pageCommItem: Any,
		@SerializedName("all_participants") val allParticipants: AllParticipants,
		@SerializedName("messages") val messagePage: MessagePage,
		@SerializedName("read_receipts") val readReceipts: ReadReceipts
)

data class LastReadReceipt(
		@SerializedName("nodes") val nodes: List<SimpleReadReceipt>
)

data class SimpleReadReceipt(
		@SerializedName("timestamp_precise") val timestampPrecise: String
)

data class RtcCallData(
		@SerializedName("call_state") val callState: String,
		@SerializedName("server_info_data") val serverInfoData: String,
		@SerializedName("initiator") val initiator: Any
)

data class LastMessage(
		@SerializedName("nodes") val nodes: List<SimpleMessageNode>
)

data class SimpleMessageNode(
		@SerializedName("snippet") val snippet: String,
		@SerializedName("message_sender") val messageSender: SimpleMessageSender,
		@SerializedName("timestamp_precise") val timestampPrecise: String,
		@SerializedName("commerce_message_type") val commerceMessageType: Any,
		@SerializedName("extensible_attachment") val extensibleAttachment: Any,
		@SerializedName("sticker") val sticker: Sticker,
		@SerializedName("blob_attachments") val blobAttachments: List<Attachment>
)

data class SimpleMessageSender(
		@SerializedName("messaging_actor") val messagingActor: SimpleMessagingActor
)

data class SimpleMessagingActor(
		@SerializedName("id") val id: String
)

data class Sticker(
		@SerializedName("id") val id: String,
		@SerializedName("pack") val pack: Pack,
		@SerializedName("label") val label: String,
		@SerializedName("frame_count") val frameCount: Int,
		@SerializedName("frame_rate") val frameRate: Int,
		@SerializedName("frames_per_row") val framesPerRow: Int,
		@SerializedName("frames_per_column") val framesPerColumn: Int,
		@SerializedName("sprite_image_2x") val spriteImage2x: Any,
		@SerializedName("sprite_image") val spriteImage: Any,
		@SerializedName("padded_sprite_image") val paddedSpriteImage: Any,
		@SerializedName("padded_sprite_image_2x") val paddedSpriteImage2x: Any,
		@SerializedName("url") val url: String,
		@SerializedName("height") val height: Int,
		@SerializedName("width") val width: Int
)

data class Pack(
		@SerializedName("id") val id: String
)

data class MessagePage(
		@SerializedName("page_info") val pageInfo: PageInfo,
		@SerializedName("nodes") val messages: List<FullMessageNode>
)

data class FullMessageNode(
		@SerializedName("__typename") val typename: String,
		@SerializedName("message_id") val messageId: String,
		@SerializedName("offline_threading_id") val offlineThreadingId: String,
		@SerializedName("message_sender") val messageSender: MessageSender,
		@SerializedName("ttl") val ttl: Int,
		@SerializedName("timestamp_precise") val timestampPrecise: String,
		@SerializedName("unread") val unread: Boolean,
		@SerializedName("is_sponsored") val isSponsored: Boolean,
		@SerializedName("ad_id") val adId: Any,
		@SerializedName("ad_client_token") val adClientToken: Any,
		@SerializedName("commerce_message_type") val commerceMessageType: Any,
		@SerializedName("customizations") val customizations: List<Any>,
		@SerializedName("tags_list") val tagsList: List<String>,
		@SerializedName("platform_xmd_encoded") val platformXmdEncoded: Any,
		@SerializedName("message_source_data") val messageSourceData: Any,
		@SerializedName("montage_reply_data") val montageReplyData: Any,
		@SerializedName("message_reactions") val messageReactions: List<Any>,
		@SerializedName("message") val message: Message,
		@SerializedName("meta_ranges") val metaRanges: List<Any>,
		@SerializedName("extensible_attachment") val extensibleAttachment: Any,
		@SerializedName("sticker") val sticker: Sticker?,
		@SerializedName("blob_attachments") val blobAttachments: List<Attachment>,
		@SerializedName("page_admin_sender") val pageAdminSender: Any
)

data class Message(
		@SerializedName("text") val text: String,
		@SerializedName("ranges") val ranges: List<Any>
)

data class MessageSender(
		@SerializedName("id") val id: String,
		@SerializedName("email") val email: String
)

data class PageInfo(
		@SerializedName("has_previous_page") val hasPreviousPage: Boolean
)

data class JoinableMode(
		@SerializedName("mode") val mode: String,
		@SerializedName("link") val link: String
)

data class AllParticipants(
		@SerializedName("nodes") val nodes: List<Participant>
)

data class Participant(
		@SerializedName("messaging_actor") val messagingActor: FullMessagingActor
)

data class FullMessagingActor(
		@SerializedName("id") val id: String,
		@SerializedName("__typename") val typename: String
)

data class ThreadKey(
		@SerializedName("thread_fbid") val threadFbid: Any,
		@SerializedName("other_user_id") val otherUserId: String
)

data class EventReminders(
		@SerializedName("nodes") val nodes: List<Any>
)

data class ReadReceipts(
		@SerializedName("nodes") val nodes: List<ReadReceipt>
)

data class ReadReceipt(
		@SerializedName("watermark") val watermark: String,
		@SerializedName("action") val action: String,
		@SerializedName("actor") val actor: Actor
)

data class Actor(
		@SerializedName("id") val id: String
)

data class CustomizationInfo(
		@SerializedName("emoji") val emoji: Any,
		@SerializedName("participant_customizations") val participantCustomizations: List<ParticipantCustomization>,
		@SerializedName("outgoing_bubble_color") val outgoingBubbleColor: String
)

data class ParticipantCustomization(
		@SerializedName("participant_id") val participantId: String,
		@SerializedName("nickname") val nickname: String
)

data class Attachment(
		@SerializedName("__typename") val type: String,
		@SerializedName("attribution_app") val attrApp: Any?,
		@SerializedName("attribution_metadata") val attrMeta: Any?,
		@SerializedName("filename") val fileName: String,
		@SerializedName("animated_image") val gif: Image?,
		@SerializedName("legacy_attachment_id") val id: String,
		@SerializedName("preview_image") val preview: Image?,
		@SerializedName("original_dimensions") val dimensions: Dimensions?
)

data class Image(
		@SerializedName("uri") val uri: String,
		@SerializedName("height") val height: Int,
		@SerializedName("width") val width: Int
)

data class Dimensions(
		@SerializedName("x") val x: Int,
		@SerializedName("y") val y: Int
)

// request object


data class RequestContainer(
		@SerializedName("o0") val query: Query
)

data class Query(
		@SerializedName("doc_id") val docId: String, //1508526735892416
		@SerializedName("query_params") val queryParams: QueryParams
)

data class QueryParams(
		@SerializedName("id") val id: String, //100000746827681
		@SerializedName("message_limit") val messageLimit: Int, //200
		@SerializedName("load_messages") val loadMessages: Int = 1, //1
		@SerializedName("load_read_receipts") val loadReadReceipts: Boolean = true, //true
		@SerializedName("before") val before: Int? = null //null
)