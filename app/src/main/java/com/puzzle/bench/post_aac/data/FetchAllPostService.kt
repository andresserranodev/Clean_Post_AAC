package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.PostEntity

interface FetchAllPostService {
    suspend fun fetchAllPost(): List<PostEntity>
}