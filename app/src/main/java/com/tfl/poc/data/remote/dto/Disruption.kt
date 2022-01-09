package com.tfl.poc.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Disruption(

    @SerialName("category")
    val category: String?,
    @SerialName("categoryDescription")
    val categoryDescription: String?,
    @SerialName("closureText")
    val closureText: String?,
    @SerialName("created")
    val created: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("\$type")
    val type: String?
)