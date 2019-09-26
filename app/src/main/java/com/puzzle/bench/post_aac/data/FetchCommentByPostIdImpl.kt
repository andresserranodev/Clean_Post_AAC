package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi

class FetchCommentByPostIdImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val commentMapper: CommentMapper
) : FetchCommentByPostId {
    override suspend fun fetchCommentByPostId(postId: Int): List<CommentEntity> {
        return jsonPlaceholderApi.getAllCommentsRequest(postId)
            .map { commentMapper.transformServiceToEntity(it) }
    }
}