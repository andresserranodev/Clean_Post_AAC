package com.puzzle.bench.post_aac.data.networking.retrofit

import com.puzzle.bench.post_aac.data.networking.responses.CommentsResponse
import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.data.networking.responses.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getAllPostRequest(): List<PostResponse>

    @GET("/users")
    suspend fun getAllUsersRequest(): List<UserResponse>

    @GET("/comments")
    suspend fun getAllCommentsRequest(@Query("postId") postId: Int): List<CommentsResponse>
}