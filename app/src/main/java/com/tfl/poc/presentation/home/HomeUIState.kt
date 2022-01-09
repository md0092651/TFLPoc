package com.tfl.poc.presentation.home

import com.tfl.poc.domain.model.TubeStatus

data class HomeUIState(
    val isLoading: Boolean = true,
    val list: List<TubeStatus>? = null,
    val isEmpty: Boolean = true,
    val error: String = ""
)
