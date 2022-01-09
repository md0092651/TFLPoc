package com.tfl.poc.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineStatuse(
    @SerialName("created")
    val created: String?,
    @SerialName("disruption")
    val disruption: Disruption?,
    @SerialName("id")
    val id: Int?,
    @SerialName("lineId")
    val lineId: String?,
    @SerialName("reason")
    val reason: String?,
    @SerialName("statusSeverity")
    val statusSeverity: Int?,
    @SerialName("statusSeverityDescription")
    val statusSeverityDescription: String?,
    @SerialName("\$type")
    val type: String?,
    @SerialName("validityPeriods")
    val validityPeriods: List<ValidityPeriod>?
)