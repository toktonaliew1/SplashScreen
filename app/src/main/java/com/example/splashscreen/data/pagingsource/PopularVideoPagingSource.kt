package com.example.youtubeapp.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bumptech.glide.load.HttpException
import com.example.splashscreen.data.remote.network.apiservisec.YouTubeApiServise
import com.example.splashscreen.domain.models.Item
import java.io.IOException
import javax.inject.Inject

class PopularVideoPagingSource @Inject constructor(
    private val service: YouTubeApiServise
) : PagingSource<String, Item>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Item> {
        return try {
            val position = params.key ?: ""
            val response = service.getChannelPlaylist(position)
            LoadResult.Page(
                data = response.items,
                prevKey = null,
                nextKey = response.nextPageToken
            )
        } catch (ioException: IOException) {
            LoadResult.Error(ioException)
        } catch (ioException: HttpException) {
            LoadResult.Error(ioException)
        }
    }

    override fun getRefreshKey(state: PagingState<String, Item>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey
        }
    }

}