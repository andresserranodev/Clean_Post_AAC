package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puzzle.bench.post_aac.data.PostStorageImpl

@Suppress("UNCHECKED_CAST")
class PostDetailViewModelFactory(
    private val postStorageImpl: PostStorageImpl,
    private val postId: Int
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        PostDetailViewModel(postStorageImpl, postId) as T
}