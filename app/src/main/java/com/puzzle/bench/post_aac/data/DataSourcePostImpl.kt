package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.MockData.Factory.getDummyListPost
import com.puzzle.bench.post_aac.model.Post

class DataSourcePostImpl : DataSourcePost {
    override fun getAllPost(): List<Post> {
        return getDummyListPost()
    }
}