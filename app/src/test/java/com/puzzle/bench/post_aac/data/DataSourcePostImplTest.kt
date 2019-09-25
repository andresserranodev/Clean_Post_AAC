package com.puzzle.bench.post_aac.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.puzzle.bench.post_aac.data.MockData.Factory.getDummyListPostResponse
import com.puzzle.bench.post_aac.data.networking.JsonPlaceholderApi
import com.puzzle.bench.post_aac.data.networking.mapper.PostMapperService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DataSourcePostImplTest {

    private lateinit var dataSourcePostImpl: DataSourcePostImpl
    private val serviceResponse = getDummyListPostResponse()
    private val service = mock<JsonPlaceholderApi> {
        onBlocking { getPostRequest() } doReturn serviceResponse
    }
    private var postMapperService = mock<PostMapperService>()


    @Before
    fun setUp() {
        dataSourcePostImpl = DataSourcePostImpl(service, postMapperService)
    }

    @Test
    fun getAllPost() {

        runBlocking {
            dataSourcePostImpl.getAllPost()
            verify(service).getPostRequest()
            verify(postMapperService).transformPresentation(serviceResponse[0])
        }
    }
}