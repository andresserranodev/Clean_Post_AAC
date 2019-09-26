package com.puzzle.bench.post_aac.data.networking.responses

import com.google.gson.annotations.SerializedName

class CommentsResponse(
    @SerializedName("id") val commentId: Int,
    val postId: Int,
    val body: String
)