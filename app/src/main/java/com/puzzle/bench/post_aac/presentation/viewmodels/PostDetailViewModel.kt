package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzle.bench.post_aac.data.PostStorageImpl
import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val postStorageImpl: PostStorageImpl,
    private val postId: Int
) : ViewModel() {

    val postInfoLiveData = postStorageImpl.getPostById(postId)


    fun updateStatus() {
        viewModelScope.launch {
            postStorageImpl.updateWasRead(postId, true)
        }
    }

    fun maskAsAFavorite() {
        viewModelScope.launch {
            postStorageImpl.updateIsFavorite(postId, true)
        }
    }
}