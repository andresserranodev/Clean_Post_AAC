package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puzzle.bench.post_aac.data.CommentStorageImpl
import com.puzzle.bench.post_aac.data.FetchCommentByPostId
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.data.UserStorageImpl

@Suppress("UNCHECKED_CAST")
class PostDetailViewModelFactory(
    private val postStorageImpl: PostStorageImpl,
    private val userStorageImpl: UserStorageImpl,
    private val commentStorageImpl: CommentStorageImpl,
    private val fetchCommentByPostId: FetchCommentByPostId,
    private val postId: Int,
    private val userId: Int
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        PostDetailViewModel(
            postStorageImpl,
            userStorageImpl,
            commentStorageImpl,
            fetchCommentByPostId,
            postId,
            userId
        ) as T
}