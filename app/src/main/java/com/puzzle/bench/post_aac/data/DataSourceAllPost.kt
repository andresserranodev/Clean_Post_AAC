package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.model.Post

interface DataSourceAllPost {
    fun getAllPost(): List<Post>
}