package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.model.Post
import kotlin.random.Random.Default.nextBoolean

class MockData {

    companion object Factory {
        const val BASE_TITLE = "This is a Dummy Title "
        const val BASE_BODY =
            "This is a Dummy Body whit a content for the Dummy Title."

        fun getDummyListPost(): List<Post> = (1..100).map {
            Post(
                it,
                it,
                "$BASE_TITLE$it",
                "$BASE_BODY$it",
                nextBoolean(),
                nextBoolean()
            )
        }
    }
}