package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.networking.JsonPlaceholderApi
import com.puzzle.bench.post_aac.data.networking.mapper.PostMapperService
import com.puzzle.bench.post_aac.model.Post

class DataSourcePostImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val postMapperService: PostMapperService
) : DataSourcePost {
    override suspend fun getAllPost(): List<Post> {
        return jsonPlaceholderApi.getPostRequest().map {
            postMapperService.transformPresentation(it)
        }
    }
}