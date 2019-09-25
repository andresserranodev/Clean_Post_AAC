package com.puzzle.bench.post_aac.data.networking.responses

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("id") val postId: Int,
    val userId: Int,
    val title: String,
    val body: String
)