package com.example.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.cleanarchicture.base.BaseRepository
import com.example.cleanarchicture.domain.repositories.YouTubeRepository
import com.example.splashscreen.data.remote.network.apiservisec.YouTubeApiServise
import com.example.splashscreen.domain.models.Item
import com.example.youtubeapp.data.pagingsource.PopularVideoPagingSource
import javax.inject.Inject

class YouTubeRepositoryImpl @Inject constructor(
    private val apiService: YouTubeApiServise
) : BaseRepository(), YouTubeRepository {

    override fun getChanelPlaylists() = doRequest {
        apiService.getChannelPlaylist()
    }

    fun fetchHeroesId(id: String) = doRequest { apiService.getChannelPlaylist(id) }

    fun fetchPopularVideos() : LiveData<PagingData<Item>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                PopularVideoPagingSource(apiService)
            }
        ).liveData
    }
}