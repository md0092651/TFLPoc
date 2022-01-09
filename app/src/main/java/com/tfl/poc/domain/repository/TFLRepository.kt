package com.tfl.poc.domain.repository

import com.tfl.poc.data.remote.dto.TubeStatusListItem

interface TFLRepository {

    suspend fun getTubeStatus():List<TubeStatusListItem>

}