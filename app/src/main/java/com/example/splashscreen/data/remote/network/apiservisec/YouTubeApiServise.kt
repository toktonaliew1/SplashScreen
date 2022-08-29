package com.example.splashscreen.data.remote.network.apiservisec


import com.example.splashscreen.domain.models.YouTubeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YouTubeApiServise {

    @GET("playlists")
    suspend fun getChannelPlaylist(
        @Query("part") part :String = "snippet",
        @Query("channelId") channelId : String = "UCKsqMPIIhev3qbMxCL8Emvw",
        @Query("key") key :String= "AIzaSyAcCV7Vqi1KRKr6ZKwms-Hd8Omi6aWCHps"
    ): YouTubeResponse

    @GET("playlist/{id}")
    suspend fun fetchHeroesId(
        @Path("id") id: Int
    ): YouTubeResponse

}