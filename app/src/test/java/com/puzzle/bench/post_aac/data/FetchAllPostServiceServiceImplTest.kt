package com.puzzle.bench.post_aac.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.data.MockData.Factory.getDummyListPostResponse
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.data.networking.JsonPlaceholderApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchAllPostServiceServiceImplTest {

    private lateinit var dataSourceAllPostServiceImpl: FetchAllPostServiceServiceImpl
    private val serviceResponse = getDummyListPostResponse()
    private val service = mock<JsonPlaceholderApi> {
        onBlocking { getAllPostRequest() } doReturn serviceResponse
    }
    private var postMapper = mock<PostMapper>()


    @Before
    fun setUp() {
        dataSourceAllPostServiceImpl = FetchAllPostServiceServiceImpl(service, postMapper)
    }

    @Test
    fun getPostRequest() {
        runBlocking {
            dataSourceAllPostServiceImpl.fetchAllPost()
            verify(service).getAllPostRequest()
            verify(postMapper).transformServiceToEntity(serviceResponse[0])
        }
    }
}