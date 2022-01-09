package com.tfl.poc.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tfl.poc.databinding.BottomsheetDetailsBinding
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.presentation.detail.adapter.DisruptionStatusAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailBottomSheetFragment(val status: TubeStatus) : BottomSheetDialogFragment() {

    private lateinit var adapter: DisruptionStatusAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = BottomsheetDetailsBinding.inflate(inflater, container, false)

        binding.textView.text = status.name
        binding.textView3.text = status.name.substring(0,1)

        val layoutManager = LinearLayoutManager(activity)
        binding.rvList.layoutManager = layoutManager
      //  binding.rvList.setHasFixedSize(true)

        adapter = DisruptionStatusAdapter( status.disruptionDetails)
        binding.rvList.adapter = adapter

        return binding.root
    }
}