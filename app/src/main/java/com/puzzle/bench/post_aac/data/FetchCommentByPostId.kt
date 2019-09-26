package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.CommentEntity

interface FetchCommentByPostId {
    suspend fun fetchCommentByPostId(postId: Int): List<CommentEntity>
}