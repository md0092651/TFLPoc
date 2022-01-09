package com.tfl.poc.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValidityPeriod(
    @SerialName("fromDate")
    val fromDate: String?,
    @SerialName("isNow")
    val isNow: Boolean?,
    @SerialName("toDate")
    val toDate: String?,
    @SerialName("\$type")
    val type: String?
)