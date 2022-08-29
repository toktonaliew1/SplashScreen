package com.example.splashscreen.presentation.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cleanarchicture.base.BaseFragment
import com.example.cleanarchicture.presentation.state.UIState
import com.example.splashscreen.R
import com.example.splashscreen.databinding.FragmentPlayListBinding
import com.example.splashscreen.presentation.ui.adapter.YouTubeAdapter
import kotlinx.coroutines.launch


class PlayListFragment :

    BaseFragment<PlayListViewModel, FragmentPlayListBinding>(R.layout.fragment_play_list) {


    override val binding by viewBinding(FragmentPlayListBinding::bind)
    override val viewModel: PlayListViewModel by viewModels()
    private val youTubeAdapter = YouTubeAdapter()
    private val args by navArgs<PlayListFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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