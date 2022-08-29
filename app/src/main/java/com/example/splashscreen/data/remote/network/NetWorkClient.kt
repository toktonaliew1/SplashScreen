package com.example.cleanarchicture.data.remote.network


import com.example.poketest.data.remote.OkHttp
import com.example.poketest.data.remote.RetrofitClient
import com.example.splashscreen.data.remote.network.apiservisec.YouTubeApiServise
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideYouTubeApiService() = provideRetrofit.create(YouTubeApiServise::class.java)
}