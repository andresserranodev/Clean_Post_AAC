package com.puzzle.bench.post_aac.data.networking

import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.data.networking.responses.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getAllPostRequest(): List<PostResponse>

    @GET("/users")
    suspend fun getAllUsersRequest(): List<UserResponse>
}