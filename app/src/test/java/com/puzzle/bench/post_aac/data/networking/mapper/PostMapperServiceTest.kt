package com.puzzle.bench.post_aac.data.networking.mapper

import com.nhaarman.mockitokotlin2.any
import com.puzzle.bench.post_aac.data.MockData.Factory.BASE_BODY
import com.puzzle.bench.post_aac.data.MockData.Factory.BASE_TITLE
import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.model.Post
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class PostMapperServiceTest {

    private lateinit var mapper: PostMapperService

    @Before
    fun setUp() {
        mapper = PostMapperService()
    }

    @Test
    fun transform() {
        val mockPostServiceResponse = PostResponse(any(), any(), BASE_TITLE, BASE_BODY)
        val result = mapper.transformPresentation(mockPostServiceResponse)
        assertPostDataEquality(mockPostServiceResponse, result)
    }

    @Test
    fun transformToResponse() {
        val mockPost = Post(any(), any(), BASE_TITLE, BASE_BODY, any(), any())
        val result = mapper.transformToResponse(mockPost)
        assertPostDataEquality(result, mockPost)
    }

    private fun assertPostDataEquality(postResponse: PostResponse, post: Post) {
        assertEquals(postResponse.userId, post.userId)
        assertEquals(postResponse.postId, post.postId)
        assertEquals(postResponse.title, post.title)
        assertEquals(postResponse.body, post.body)


    }
}