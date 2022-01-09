package com.tfl.poc.presentation.helper

import com.tfl.poc.domain.model.TubeStatus

interface RecyclerItemListener {
    fun onItemSelected(status : TubeStatus)
}
