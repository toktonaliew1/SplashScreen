package com.example.coinsapp.presentation.ui.models


data class YouTubeModelUI(
    val id: Int,
    val name: String,
    val url : String,
    val pokemonId : Int = url.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "").toInt()

)

fun YouTubeModelUI.toUI() = YouTubeModelUI(id, name, url)
