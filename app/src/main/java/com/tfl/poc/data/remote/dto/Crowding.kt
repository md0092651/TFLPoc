package com.tfl.poc.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Crowding(
    @SerialName("\$type")
    val type: String?
)