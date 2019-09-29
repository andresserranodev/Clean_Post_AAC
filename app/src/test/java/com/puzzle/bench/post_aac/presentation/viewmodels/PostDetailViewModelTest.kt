package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.data.CommentStorageImpl
import com.puzzle.bench.post_aac.data.FetchCommentByPostId
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.data.UserStorageImpl
import com.puzzle.bench.post_aac.model.FetchCommentsState
import com.puzzle.bench.post_aac.utils.CoroutinesTestRule
import com.puzzle.bench.post_aac.utils.MockData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.rules.TestRule

class PostDetailViewModelTest {

    private val userId = 1
    private val postId = 1
    private val postStorageImpl = mock<PostStorageImpl>()
    private val userStorageImpl = mock<UserStorageImpl>()
    private val commentStorageImpl = mock<CommentStorageImpl>()
    private val serviceResponse = MockData.getDummyListCommentEntity()

    private val fetchCommentByPostId = mock<FetchCommentByPostId> {
        onBlocking { fetchCommentByPostId(1) } doReturn FetchCommentsState("", serviceResponse)
    }


    private lateinit var viewModel: PostDetailViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Before
    fun setUp() {
        viewModel = PostDetailViewModel(
            postStorageImpl,
            userStorageImpl,
            commentStorageImpl,
            fetchCommentByPostId,
            postId,
            userId
        )
    }


    @ExperimentalCoroutinesApi
    @Test
    fun fetchComments() {
        viewModel.fetchComments()
        runBlocking {
            verify(fetchCommentByPostId).fetchCommentByPostId(postId)
            verify(commentStorageImpl).insertAll(serviceResponse)

        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun fetchCommentsError() {

        val fetchCommentByPostId = mock<FetchCommentByPostId> {
            onBlocking { fetchCommentByPostId(1) } doReturn FetchCommentsState("afdfs", listOf())
        }
        val viewModel = PostDetailViewModel(
            postStorageImpl,
            userStorageImpl,
            commentStorageImpl,
            fetchCommentByPostId,
            postId,
            userId
        )
        viewModel.fetchComments()
        runBlocking {
            verify(fetchCommentByPostId).fetchCommentByPostId(postId)
        }
    }

    @Test
    fun updateStatus() {
        viewModel.updateStatus()
        runBlocking {
            verify(postStorageImpl).updateWasRead(postId, true)
        }
    }

    @Test
    fun maskAsAFavorite() {
        viewModel.maskAsAFavorite()
        runBlocking {
            verify(postStorageImpl).updateIsFavorite(postId, true)
        }
    }

    @Test
    fun removeFromFavorite() {
        viewModel.removeFromFavorite()
        runBlocking {
            verify(postStorageImpl).updateIsFavorite(postId, false)
        }
    }
}