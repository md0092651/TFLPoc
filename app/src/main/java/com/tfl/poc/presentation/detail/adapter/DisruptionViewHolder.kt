package com.tfl.poc.presentation.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tfl.poc.R
import com.tfl.poc.databinding.TflDisruptionItemBinding
import com.tfl.poc.domain.model.DisruptionDetails
import com.tfl.poc.domain.model.TubeStatus


class DisruptionViewHolder(private val itemBinding: TflDisruptionItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(detail: DisruptionDetails) {
        itemBinding.textView.text = "Severity ${detail.statusSeverity}"
        itemBinding.chip4.text = detail.category
        itemBinding.textView2.text = detail.description
        itemBinding.textView4.text = detail.created


    }
}

