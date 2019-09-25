package com.puzzle.bench.post_aac.model

data class Post(
    val userId: Int,
    val postId: Int,
    val title: String,
    val body: String,
    val wasRead: Boolean,
    val isFavorite: Boolean
)