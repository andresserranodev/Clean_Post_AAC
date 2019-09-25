package com.puzzle.bench.post_aac.model

data class Post(
    val postId: Int = 0,
    val userId: Int,
    val title: String,
    val body: String,
    val wasRead: Boolean,
    val isFavorite: Boolean
)