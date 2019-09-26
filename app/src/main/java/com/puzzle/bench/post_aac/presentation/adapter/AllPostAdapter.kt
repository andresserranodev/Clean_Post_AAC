package com.puzzle.bench.post_aac.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.puzzle.bench.post_aac.databinding.PostItemBinding
import com.puzzle.bench.post_aac.model.Post
import com.puzzle.bench.post_aac.presentation.fragment.HomeViewPagerFragmentDirections

class AllPostAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(AllPostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            PostItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PostViewHolder).bind(getItem(position))
    }

    class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.post?.let { post ->
                    navigateToPostDetails(post, it)
                }
            }
        }

        fun bind(item: Post) {
            binding.apply {
                post = item
                executePendingBindings()
            }
        }

        private fun navigateToPostDetails(
            post: Post,
            view: View
        ) {
            val action =
                HomeViewPagerFragmentDirections.actionHomeViewPagerFragmentToPostDetailFragment()
            action.postId = post.postId
            action.userId = post.userId
            Navigation.findNavController(view).navigate(action)
        }
    }

}

private class AllPostDiffCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.postId == newItem.postId
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}