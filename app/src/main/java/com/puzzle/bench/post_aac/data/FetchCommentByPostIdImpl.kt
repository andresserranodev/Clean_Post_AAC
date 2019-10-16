package com.puzzle.bench.post_aac.data

import android.os.StrictMode
import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi
import com.puzzle.bench.post_aac.model.FetchCommentsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val NO_ERROR = ""

class FetchCommentByPostIdImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val commentMapper: CommentMapper
) : FetchCommentByPostId {
    override suspend fun fetchCommentByPostId(postId: Int): FetchCommentsState = withContext(
        Dispatchers.IO
    ) {
        return@withContext try {
            val response = jsonPlaceholderApi.getAllCommentsRequest(postId).map {
                commentMapper.transformServiceToEntity(it)
            }
            FetchCommentsState(NO_ERROR, response)
        } catch (ex: Exception) {
            FetchCommentsState(ex.message.toString(), listOf())
        }

    }
}
