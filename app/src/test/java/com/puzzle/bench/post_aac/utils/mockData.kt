package com.puzzle.bench.post_aac.utils

import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.networking.responses.CommentsResponse
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


        fun getDummyListPostEntity(): List<PostEntity> = (1..100).map {
            PostEntity(
                it,
                it,
                "$BASE_TITLE$it",
                "$BASE_BODY$it",
                true,
                nextBoolean()
            )
        }

        fun getDummyListCommentEntity(): List<CommentEntity> = (1..20).map {
            CommentEntity(
                it,
                it,
                "$BASE_BODY$it"
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

        fun getDummyListCommentResponse(): List<CommentsResponse> = (1..20).map {
            CommentsResponse(
                it,
                it,
                "$BASE_BODY$it"
            )
        }
    }
}