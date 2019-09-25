package com.puzzle.bench.post_aac.data.networking

import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getPostRequest(): List<PostResponse>
}