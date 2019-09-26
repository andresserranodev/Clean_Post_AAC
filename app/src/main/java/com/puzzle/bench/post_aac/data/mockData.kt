package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.data.networking.responses.UserResponse
import com.puzzle.bench.post_aac.model.Post
import kotlin.random.Random.Default.nextBoolean

class MockData {

    companion object Factory {
        const val BASE_TITLE = "This is a Dummy Title "
        const val BASE_BODY =
            "This is a Dummy Body whit a content for the Dummy Title."


        const val BASE_NAME = "Dummy Name "
        const val BASE_EMAIL = "Dummy@email.com "
        const val BASE_PHONE = "(121)-3123132"
        const val BASE_WEB_SITE = "www.dummy.com"


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

        fun getDummyListPostResponse(): List<PostResponse> = (1..20).map {
            PostResponse(
                it,
                it,
                "$BASE_TITLE$it",
                "$BASE_BODY$it"
            )
        }

        fun getDummyListUserResponse(): List<UserResponse> = (1..20).map {
            UserResponse(
                it,
                "$BASE_NAME$it",
                "$BASE_EMAIL$it",
                "$BASE_PHONE$it",
                "$BASE_WEB_SITE$it"
            )
        }
    }
}