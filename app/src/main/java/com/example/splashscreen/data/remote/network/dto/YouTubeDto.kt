package com.example.cleanarchicture.data.remote.network.dto

import com.example.cleanarchicture.domain.models.YouTubeModel
import com.example.coinsapp.presentation.ui.models.YouTubeModelUI
import com.google.gson.annotations.SerializedName

data class YouTubeDto (

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url : String

    )
fun YouTubeDto.toDomain() = YouTubeModel(id,name,url)