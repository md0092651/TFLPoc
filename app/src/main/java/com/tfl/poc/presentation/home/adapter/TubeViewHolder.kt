package com.tfl.poc.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tfl.poc.R
import com.tfl.poc.databinding.TflItemBinding
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.presentation.helper.RecyclerItemListener

class TubeViewHolder(private val itemBinding: TflItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(status: TubeStatus, recyclerItemListener: RecyclerItemListener) {
        itemBinding.textView.text = status.name
        if(status.hasDisruption){
            itemBinding.imageView.setImageResource(R.drawable.ic_delay)
        }else{
            itemBinding.imageView.setImageResource(R.drawable.ic_on_time)
        }
        itemBinding.rlRecipeItem.setOnClickListener { recyclerItemListener.onItemSelected(status) }
    }
}

