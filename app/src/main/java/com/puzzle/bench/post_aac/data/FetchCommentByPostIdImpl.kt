package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi
import com.puzzle.bench.post_aac.model.FetchCommentsState

const val NO_ERROR = ""

class FetchCommentByPostIdImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val commentMapper: CommentMapper
) : FetchCommentByPostId {
    override suspend fun fetchCommentByPostId(postId: Int): FetchCommentsState {
        return try {
            val response = jsonPlaceholderApi.getAllCommentsRequest(postId).map {
                commentMapper.transformServiceToEntity(it)
            }
            FetchCommentsState(NO_ERROR, response)
        } catch (ex: Exception) {
            FetchCommentsState(ex.message.toString(), listOf())
        }

    }
}
