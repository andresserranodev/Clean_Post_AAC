package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzle.bench.post_aac.data.CommentStorageImpl
import com.puzzle.bench.post_aac.data.FetchCommentByPostId
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.data.UserStorageImpl

import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val postStorageImpl: PostStorageImpl,
    userStorageImpl: UserStorageImpl,
    private val commentStorageImpl: CommentStorageImpl,
    private val fetchCommentByPostId: FetchCommentByPostId,
    private val postId: Int,
    userId: Int

) : ViewModel() {

    val postInfoLiveData = postStorageImpl.getPostById(postId)
    val userInfoLiveData = userStorageImpl.getUserById(userId)
    val commentsLiveData = commentStorageImpl.getCommentsByPostId(postId)


    fun fetchComments() {
        viewModelScope.launch {
            commentStorageImpl.insertAll(fetchCommentByPostId.fetchCommentByPostId(postId))
        }
    }

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

    fun removeFromFavorite() {
        viewModelScope.launch {
            postStorageImpl.updateIsFavorite(postId, false)
        }
    }

}