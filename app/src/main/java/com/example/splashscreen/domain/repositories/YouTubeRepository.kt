package com.example.cleanarchicture.domain.repositories

import com.example.cleanarchicture.domain.either.Either
import com.example.splashscreen.domain.models.YouTubeResponse

import kotlinx.coroutines.flow.Flow

interface YouTubeRepository {

    fun getChanelPlaylists() : Flow<Either<String, YouTubeResponse>>

}