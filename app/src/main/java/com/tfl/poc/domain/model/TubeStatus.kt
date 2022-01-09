package com.tfl.poc.domain.model

data class TubeStatus(
    var name:String ="",
    var id:String = "",
    var hasDisruption:Boolean = false,
    var disruptionDetails : List<DisruptionDetails> = emptyList()
)

data class DisruptionDetails(
    var statusSeverity:Int?,
    var category:String?="",
    var description:String?="",
    var created:String?=""
)