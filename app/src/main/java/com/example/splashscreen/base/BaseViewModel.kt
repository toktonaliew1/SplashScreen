package com.example.cleanarchicture.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.cleanarchicture.domain.either.Either
import com.example.cleanarchicture.presentation.state.UIState

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <P : Any> mutableStateWithPagingFlow() = MutableStateFlow<PagingData<P>?>(null)

    protected fun <T, S> Flow<Either<String, T>>.collectRequest(
        state: MutableLiveData<UIState<S>>,
        mapData: (T) -> S
    ) {
        viewModelScope.launch() {
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mapData(it.value))
                }
            }
        }
    }
}