package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.model.Post

interface DataSourcePost {
    fun getAllPost(): List<Post>
}