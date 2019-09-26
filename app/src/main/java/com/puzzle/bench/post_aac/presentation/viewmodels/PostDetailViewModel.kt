package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.model.Post
import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val postStorageImpl: PostStorageImpl,
    private val postId: Int
) : ViewModel() {

    private val postInfoLiveData: MutableLiveData<Post> = MutableLiveData()

    fun getDetails() {
        viewModelScope.launch {
            postInfoLiveData.postValue(postStorageImpl.getPostById(postId))
        }
    }

    fun getPostInfoLiveData() = postInfoLiveData
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