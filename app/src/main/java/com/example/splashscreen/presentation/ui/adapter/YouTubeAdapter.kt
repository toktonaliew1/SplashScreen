package com.example.splashscreen.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.splashscreen.databinding.ItemYoutubeBinding
import com.example.splashscreen.domain.models.Item
import com.example.youtubeapp.extensions.loadImage


class YouTubeAdapter: androidx.recyclerview.widget.ListAdapter<Item, YouTubeAdapter.ViewHolder>(CoinDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemYoutubeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }


    inner class ViewHolder(
        private val binding: ItemYoutubeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Item) = with(binding) {
            itemHeroesName.text = item.snippet.title
            item.snippet.thumbnails.medium.url.let { image.loadImage(it) }

        }
    }

    object CoinDiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(
            oldItem: Item,
            newItem: Item
        )
                : Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Item,
            newItem: Item
        ): Boolean {
            return oldItem == newItem
        }
    }
}
