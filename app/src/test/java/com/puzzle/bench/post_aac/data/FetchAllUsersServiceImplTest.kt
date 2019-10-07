package com.puzzle.bench.post_aac.data

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.utils.MockData.Factory.getDummyListUserResponse
import com.puzzle.bench.post_aac.data.mapper.UserMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchAllUsersServiceImplTest {

    private lateinit var fetchAllPostServiceImpl: FetchAllUsersServiceImpl
    private val serviceResponse = getDummyListUserResponse()
    private val service = mock<JsonPlaceholderApi> {
        onBlocking { getAllUsersRequest() } doReturn serviceResponse
    }

    private val userMapper = mock<UserMapper>()
    @Before
    fun setUp() {
        fetchAllPostServiceImpl = FetchAllUsersServiceImpl(service, userMapper)
    }

    @Test
    fun fetchAllUsers() {
        runBlocking {
            fetchAllPostServiceImpl.fetchAllUsers()
            verify(service).getAllUsersRequest()
            verify(userMapper).transformServiceToEntity(serviceResponse[0])

        }
    }
}