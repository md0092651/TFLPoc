package com.tfl.poc.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tfl.poc.databinding.TflItemBinding
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.presentation.detail.adapter.DisruptionViewHolder
import com.tfl.poc.presentation.helper.RecyclerItemListener


class TubeStatusAdapter(private val onItemClickListener: RecyclerItemListener, private val status: List<TubeStatus>) : RecyclerView.Adapter<TubeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TubeViewHolder {
        val itemBinding = TflItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TubeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TubeViewHolder, position: Int) {
        holder.bind(status[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return status.size
    }
}

