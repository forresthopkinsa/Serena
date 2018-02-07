package com.forresthopkinsa

import com.forresthopkinsa.model.Query
import com.forresthopkinsa.model.QueryParams
import com.forresthopkinsa.model.RequestContainer
import com.typesafe.config.ConfigFactory

object Config {
	
	private val config = ConfigFactory.defaultApplication()
	
	private val dtsg = config.getString("dtsg")
	private val c_user = config.getString("c_user")
	private val xs = config.getString("xs")
	
	private const val DOC_ID = "1508526735892416"
	private const val SERENA_ID = "100000746827681"
	
	val request: Request
		get() {
			val query = RequestContainer(Query(DOC_ID, QueryParams(SERENA_ID, 15)))
			
			return Request(dtsg, c_user, xs, query)
		}
	
	val myId = c_user
	val herId = SERENA_ID
	
}