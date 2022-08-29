package com.example.cleanarchicture.di

import com.example.cleanarchicture.data.remote.network.NetWorkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkClient {

    @Singleton
    @Provides
    fun provideYouTubesApiService(netWorkClient: NetWorkClient) =
        netWorkClient.provideYouTubeApiService()
}