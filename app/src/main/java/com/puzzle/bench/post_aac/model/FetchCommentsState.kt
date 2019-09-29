package com.puzzle.bench.post_aac.model

import com.puzzle.bench.post_aac.data.database.entity.CommentEntity

class FetchCommentsState(
    val error: String,
    val listComments: List<CommentEntity>
)