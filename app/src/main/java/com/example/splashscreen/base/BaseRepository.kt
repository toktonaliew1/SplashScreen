package com.example.cleanarchicture.base

import android.util.Log
import com.example.cleanarchicture.domain.either.Either

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(
        doSomethingInSuccess: ((T) -> Unit)? = null,
        request: suspend () -> T
    ) = flow<Either<String, T>> {
        request().also { data ->
            doSomethingInSuccess?.invoke(data)
            emit(Either.Right(value = data))
        }
    }.flowOn(Dispatchers.IO).catch { exception ->
        Log.e("RepositoryError", this@BaseRepository.javaClass.name, exception)
        emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
    }
}