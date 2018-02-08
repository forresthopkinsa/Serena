package com.forresthopkinsa

import com.google.gson.GsonBuilder

val gson = GsonBuilder().serializeNulls().create()!!

fun getName(id: String) = when (id) {
	Config.myId -> "Forrest"
	Config.herId -> "Serena "
	else -> throw IllegalArgumentException("Unrecognized user ID")
}