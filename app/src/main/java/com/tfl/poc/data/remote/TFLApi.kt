package com.tfl.poc.data.remote

import com.tfl.poc.data.remote.dto.TubeStatusListItem
import retrofit2.http.GET

interface TFLApi {

    @GET("/Line/Mode/Tube/Status")
    suspend fun getTubeStatus() :List<TubeStatusListItem>

}