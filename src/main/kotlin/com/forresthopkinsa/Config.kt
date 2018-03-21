package com.forresthopkinsa

import com.forresthopkinsa.model.dto.Query
import com.forresthopkinsa.model.dto.QueryParams
import com.forresthopkinsa.model.dto.RequestContainer
import com.typesafe.config.ConfigFactory

object Config {
	
	private val config = ConfigFactory.defaultApplication()
	
	private val dtsg = config.getString("dtsg")
	private val c_user = config.getString("c_user")
	private val xs = config.getString("xs")
	
	private val docId = config.getString("doc_id")
	private val serenaId = config.getString("serena_id")
	private val messages = config.getInt("message_limit")
	private val before = config.getString("before_instant").takeIf { !it.isNullOrBlank() }?.toBigIntegerOrNull()
	
	val request: Request
		get() {
			val query = RequestContainer(Query(docId, QueryParams(serenaId, messages, before = before)))
			
			return Request(dtsg, c_user, xs, query)
		}
	
	val myId = c_user!!
	val herId = serenaId!!
	
}