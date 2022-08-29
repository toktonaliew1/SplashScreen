package com.example.cleanarchicture.di

import com.example.cleanarchicture.domain.repositories.YouTubeRepository
import com.example.data.repositories.YouTubeRepositoryImpl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideYouTubeRepository(repositoryImpl: YouTubeRepositoryImpl): YouTubeRepository
}