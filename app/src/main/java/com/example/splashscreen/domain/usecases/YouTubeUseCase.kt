package com.example.cleanarchicture.domain.usecases

import com.example.cleanarchicture.domain.repositories.YouTubeRepository
import javax.inject.Inject

class YouTubeUseCase @Inject constructor(
    private val repository: YouTubeRepository
) {
    operator fun invoke() = repository.getChanelPlaylists()

}