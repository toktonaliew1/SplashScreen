package com.example.splashscreen.presentation.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding

import com.example.cleanarchicture.base.BaseFragment

import com.example.cleanarchicture.presentation.state.UIState
import com.example.splashscreen.R
import com.example.splashscreen.databinding.FragmentYoutubeBinding

import com.example.splashscreen.presentation.ui.adapter.YouTubeAdapter

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class YouTubeFragment :
    BaseFragment<YouTubeViewModel, FragmentYoutubeBinding>(
        R.layout.fragment_youtube
    ) {


    override val binding by viewBinding(FragmentYoutubeBinding::bind)
    override val viewModel: YouTubeViewModel by viewModels()
    private val youTubeAdapter = YouTubeAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.recyclerPokemon) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = youTubeAdapter
    }

    override fun setupSubscribes() {
        setupCollect()
    }

    private fun setupCollect() {
        lifecycleScope.launch{
            viewModel.youtubeState.collect{
                when (it) {
                    is UIState.Error -> {
                        Log.e("anime", it.error)
                    }
                    is UIState.Idle -> {

                    }
                    is UIState.Loading ->{

                    }
                    is UIState.Success -> {
                        youTubeAdapter.submitList(it.data.items)
                    }
                }
            }
        }
    }
}

