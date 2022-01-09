package com.tfl.poc.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tfl.poc.databinding.TflDisruptionItemBinding
import com.tfl.poc.domain.model.DisruptionDetails


class DisruptionStatusAdapter(private val details: List<DisruptionDetails>) : RecyclerView.Adapter<DisruptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisruptionViewHolder {
        val itemBinding = TflDisruptionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DisruptionViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DisruptionViewHolder, position: Int) {
        holder.bind(details[position])
    }

    override fun getItemCount(): Int {
        return details.size
    }
}

