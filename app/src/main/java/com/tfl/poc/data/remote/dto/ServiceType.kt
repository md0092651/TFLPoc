package com.tfl.poc.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ServiceType(
    @SerialName("name")
    val name: String?,
    @SerialName("\$type")
    val type: String?,
    @SerialName("uri")
    val uri: String?
)