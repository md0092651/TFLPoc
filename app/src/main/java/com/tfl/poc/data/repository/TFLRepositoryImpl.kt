package com.tfl.poc.data.repository

import com.tfl.poc.data.remote.TFLApi
import com.tfl.poc.data.remote.dto.TubeStatusListItem
import com.tfl.poc.domain.repository.TFLRepository
import javax.inject.Inject

class TFLRepositoryImpl @Inject constructor(
    private val api: TFLApi
)  : TFLRepository {

    override suspend fun getTubeStatus(): List<TubeStatusListItem> {
        return api.getTubeStatus()
    }

}