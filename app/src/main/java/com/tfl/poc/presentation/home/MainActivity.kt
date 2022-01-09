package com.tfl.poc.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tfl.poc.presentation.detail.DetailBottomSheetFragment
import com.tfl.poc.databinding.ActivityMainBinding
import com.tfl.poc.domain.model.TubeStatus
import com.tfl.poc.presentation.helper.RecyclerItemListener
import com.tfl.poc.presentation.home.adapter.TubeStatusAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),RecyclerItemListener {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TubeStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager = LinearLayoutManager(this)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)

        lifecycleScope.launch {
            homeViewModel.uiState.collect {
                when {
                    it.list?.isEmpty() == true -> {
                        binding.loading.visibility = View.GONE
                        binding.tvNoData.visibility = View.VISIBLE
                        binding.tvNoData.text = it.error
                    }
                    it.list != null -> {
                        binding.loading.visibility = View.GONE
                        adapter = TubeStatusAdapter(this@MainActivity, it.list)
                        binding.rvList.adapter = adapter
                    }
                    it.error.isNotEmpty() -> {
                        binding.loading.visibility = View.GONE
                        binding.tvNoData.visibility = View.VISIBLE
                        binding.tvNoData.text = it.error
                    }
                    it.isLoading -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onItemSelected(status: TubeStatus) {
        if(status.hasDisruption) {
            val bottomSheet = DetailBottomSheetFragment(status)
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }else{
            Toast.makeText(this,"Its on time",Toast.LENGTH_SHORT).show()
        }
    }
}