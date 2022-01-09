package com.tfl.poc.domain.usecase

import com.tfl.poc.data.remote.dto.toTubeStatus
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.domain.repository.TFLRepository
import com.tfl.poc.utility.Logger
import com.tfl.poc.utility.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetTFLStatusUseCase @Inject constructor(
    private val repository: TFLRepository
) {
    operator fun invoke(): Flow<Resource<List<TubeStatus>>> = flow {
        try {
            emit(Resource.Loading<List<TubeStatus>>())
            val tubeStatus = repository.getTubeStatus().map { it.toTubeStatus() }
            emit(Resource.Success<List<TubeStatus>>(tubeStatus))
        } catch(e: Exception) {
            Logger.e(msg = "Exception occured -> ${e.cause}", throwable = e)
        }
    }
}


