package com.puzzle.bench.post_aac.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchCommentByPostIdImplTest {

    private lateinit var fetchCommentByPostIdImpl: FetchCommentByPostIdImpl
    private val serviceResponse = MockData.getDummyListCommentResponse()
    private val service = mock<JsonPlaceholderApi> {
        onBlocking { getAllCommentsRequest(1) } doReturn serviceResponse
    }
    private val mapper = mock<CommentMapper>()

    @Before
    fun setUp() {

        fetchCommentByPostIdImpl = FetchCommentByPostIdImpl(service, mapper)
    }

    @Test
    fun fetchCommentByPostId() {

        runBlocking {
            fetchCommentByPostIdImpl.fetchCommentByPostId(1)
            verify(service).getAllCommentsRequest(1)
            verify(mapper).transformServiceToEntity(serviceResponse[0])
        }
    }
}