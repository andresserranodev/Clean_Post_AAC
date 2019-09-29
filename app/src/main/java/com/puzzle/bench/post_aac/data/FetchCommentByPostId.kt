package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.model.FetchCommentsState

interface FetchCommentByPostId {
    suspend fun fetchCommentByPostId(postId: Int): FetchCommentsState
}