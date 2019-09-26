package com.puzzle.bench.post_aac.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.bench.post_aac.databinding.CommentItemBinding
import com.puzzle.bench.post_aac.databinding.FavoritePostItemBinding
import com.puzzle.bench.post_aac.model.Comment
import com.puzzle.bench.post_aac.model.Post

class FavoritePostAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(FavoritePostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FavoritePostViewHolder(
            FavoritePostItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = getItem(position)
        (holder as FavoritePostViewHolder).bind(post)
    }

    class FavoritePostViewHolder(
        private val binding: FavoritePostItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Post) {
            binding.apply {
                post = item
                executePendingBindings()
            }
        }
    }

}


private class FavoritePostDiffCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.postId == newItem.postId
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}