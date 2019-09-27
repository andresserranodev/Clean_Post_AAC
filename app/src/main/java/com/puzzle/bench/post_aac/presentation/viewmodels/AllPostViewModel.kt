package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.*
import com.puzzle.bench.post_aac.data.PostStorageImpl
import kotlinx.coroutines.launch

class AllPostViewModel internal constructor(
    private val postStorageImpl: PostStorageImpl
) :
    ViewModel() {

    val allPostLiveData = postStorageImpl.getAllPost()

    fun deleteAll() {
        viewModelScope.launch {
            postStorageImpl.deleteAll()
        }
    }

    fun deletePost(postId: Int) {
        viewModelScope.launch {
            postStorageImpl.deleteByIdPost(postId)
        }
    }
}
