package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi
import com.puzzle.bench.post_aac.model.FetchCommentsState

const val NO_ERROR = ""
const val NO_RECORDS_FOUND = "No records found"

class FetchCommentByPostIdImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val commentMapper: CommentMapper
) : FetchCommentByPostId {
    override suspend fun fetchCommentByPostId(postId: Int): FetchCommentsState {
        try {
            val response = jsonPlaceholderApi.getAllCommentsRequest(postId)

            val listComments = response.let { listCommentsResponse ->
                listCommentsResponse.map { commentMapper.transformServiceToEntity(it) }
            }
            return if (listComments.isEmpty()) {
                FetchCommentsState(NO_RECORDS_FOUND, listOf())

            } else {
                FetchCommentsState(NO_ERROR, listComments)
            }

        } catch (ex: Exception) {
            return FetchCommentsState(ex.message.toString(), listOf())
        }

    }
}
