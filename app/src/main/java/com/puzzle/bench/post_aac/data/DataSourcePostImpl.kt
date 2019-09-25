package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.networking.JsonPlaceholderApi
import com.puzzle.bench.post_aac.model.Post
import kotlin.random.Random

class DataSourcePostImpl(private val jsonPlaceholderApi: JsonPlaceholderApi) : DataSourcePost {
    override suspend fun getAllPost(): List<Post> {
        return jsonPlaceholderApi.getPostRequest().map {
            Post(
                it.userId,
                it.postId,
                it.title,
                it.body,
                Random.nextBoolean(),
                Random.nextBoolean()
            )
        }
    }
}