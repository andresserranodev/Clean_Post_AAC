package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.utils.MockData
import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.model.Post
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import kotlin.random.Random

class PostMapperTest {

    private lateinit var mapper: PostMapper

    @Before
    fun setUp() {
        mapper = PostMapper()
    }

    @Test
    fun transformServiceToEntity() {
        val mockPostServiceResponse =
            PostResponse(1, 2, MockData.BASE_TITLE, MockData.BASE_BODY)
        val result = mapper.transformServiceToEntity(mockPostServiceResponse)
        assertPostDataEquality(mockPostServiceResponse, result)
    }

    @Test
    fun transformEntityToPresentation() {
        val mockPostEntity =
            PostEntity(
                1, 2, MockData.BASE_TITLE, MockData.BASE_BODY, Random.nextBoolean(),
                Random.nextBoolean()
            )
        val result = mapper.transformEntityToPresentation(mockPostEntity)
        assertPostDataEquality(mockPostEntity, result)
    }


    private fun assertPostDataEquality(postResponse: PostResponse, postEntity: PostEntity) {
        assertEquals(postResponse.userId, postEntity.userId)
        assertEquals(postResponse.postId, postEntity.idPost)
        assertEquals(postResponse.title, postEntity.title)
        assertEquals(postResponse.body, postEntity.body)
    }

    private fun assertPostDataEquality(postEntity: PostEntity, post: Post) {
        assertEquals(postEntity.userId, post.userId)
        assertEquals(postEntity.idPost, post.postId)
        assertEquals(postEntity.title, post.title)
        assertEquals(postEntity.body, post.body)

    }
}