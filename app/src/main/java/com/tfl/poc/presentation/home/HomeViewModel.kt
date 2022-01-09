package com.tfl.poc.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.domain.usecase.GetTFLStatusUseCase
import com.tfl.poc.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeScreenUseCase: GetTFLStatusUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState

    init {
        fetchData();
    }

    private fun fetchData() {
        homeScreenUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    if (result.data?.isEmpty() == true){
                        _uiState.value = HomeUIState(isEmpty = true, isLoading = false)
                    }else {
                        _uiState.value = HomeUIState(list = result.data, isLoading = false)
                    }
                }
                is Resource.Loading -> {
                    _uiState.value = HomeUIState(isLoading = true)
                }
                is Resource.Error -> {
                    _uiState.value =
                        HomeUIState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )
                }
            }
        }.launchIn(viewModelScope)

    }

    fun openDisruptionDetail(recipe: TubeStatus) {

    }
}