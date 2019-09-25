package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.data.networking.JsonPlaceholderApi

class FetchAllPostServiceServiceImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val postMapper: PostMapper
) : FetchAllPostService {
    override suspend fun fetchAllPost(): List<PostEntity> {
        return jsonPlaceholderApi.getAllPostRequest().map {
            postMapper.transformServiceToEntity(it)
        }
    }
}