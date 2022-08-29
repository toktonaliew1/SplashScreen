package com.example.splashscreen.presentation.ui.fragments.detail

import androidx.lifecycle.viewModelScope
import androidx.navigation.navArgument
import com.example.cleanarchicture.base.BaseViewModel
import com.example.cleanarchicture.domain.either.Either
import com.example.cleanarchicture.domain.repositories.YouTubeRepository
import com.example.cleanarchicture.domain.usecases.YouTubeUseCase
import com.example.cleanarchicture.presentation.state.UIState
import com.example.data.repositories.YouTubeRepositoryImpl
import com.example.splashscreen.domain.models.YouTubeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayListViewModel  @Inject constructor(private val fetchYouTubeUseCase: YouTubeUseCase) :
    BaseViewModel() {

    private val _youtubeState = MutableStateFlow<UIState<YouTubeResponse>>(UIState.Loading())
    val youtubeState  = _youtubeState.asStateFlow()

    init {
        getUserdata()
    }

    private fun getUserdata() = viewModelScope.launch {
        _youtubeState.value = UIState.Loading()
        fetchYouTubeUseCase().collect{
            when (it){
                is Either.Left -> _youtubeState.value = UIState.Error(it.value)
                is Either.Right -> _youtubeState.value = UIState.Success(it.value)
            }
        }
    }
}