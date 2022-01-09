package com.tfl.poc.data.remote.dto


import com.tfl.poc.domain.model.DisruptionDetails
import com.tfl.poc.domain.model.TubeStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TubeStatusListItem(
    @SerialName("created")
    val created: String?,
    @SerialName("crowding")
    val crowding: Crowding?,
    @SerialName("disruptions")
    val disruption: List<Disruption>?,
    @SerialName("id")
    val id: String,
    @SerialName("lineStatuses")
    val lineStatuses: List<LineStatuse>?,
    @SerialName("modeName")
    val modeName: String?,
    @SerialName("modified")
    val modified: String?,
    @SerialName("name")
    val name: String,
    @SerialName("serviceTypes")
    val serviceTypes: List<ServiceType>?,
    @SerialName("\$type")
    val type: String?
)

fun TubeStatusListItem.toTubeStatus(): TubeStatus {
    val status = TubeStatus(name = name, id = id)
    if (lineStatuses.isNullOrEmpty()) {
        status.hasDisruption = false
    }else{
       status.disruptionDetails = lineStatuses.filter {
            it.statusSeverity != 10
        }.map {
            status.hasDisruption = true
            DisruptionDetails(statusSeverity = it.statusSeverity,
            category = it.disruption?.category,
            description = it.disruption?.description,
            created = it.disruption?.created)
        }
    }
    return status
}