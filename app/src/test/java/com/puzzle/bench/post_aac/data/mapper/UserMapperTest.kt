package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.utils.MockData.Factory.BASE_EMAIL
import com.puzzle.bench.post_aac.utils.MockData.Factory.BASE_NAME
import com.puzzle.bench.post_aac.utils.MockData.Factory.BASE_PHONE
import com.puzzle.bench.post_aac.utils.MockData.Factory.BASE_WEB_SITE
import com.puzzle.bench.post_aac.data.database.entity.UserEntity
import com.puzzle.bench.post_aac.data.networking.responses.UserResponse
import com.puzzle.bench.post_aac.model.User
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UserMapperTest {

    private lateinit var userMapper: UserMapper

    @Before
    fun setUp() {
        userMapper = UserMapper()
    }

    @Test
    fun transformServiceToEntity() {
        val mockServiceResponse = UserResponse(1, BASE_NAME, BASE_EMAIL, BASE_PHONE, BASE_WEB_SITE)
        val resultEntity = userMapper.transformServiceToEntity(mockServiceResponse)
        assertPostDataEquality(mockServiceResponse, resultEntity)

    }

    @Test
    fun transformEntityToPresentation() {
        val mockEntity = UserEntity(1, BASE_NAME, BASE_EMAIL, BASE_PHONE, BASE_WEB_SITE)
        val result = userMapper.transformEntityToPresentation(mockEntity)
        assertPostDataEquality(mockEntity, result)
    }

    private fun assertPostDataEquality(userResponse: UserResponse, userEntity: UserEntity) {
        assertEquals(userResponse.userId, userEntity.userId)
        assertEquals(userEntity.name, userEntity.name)
        assertEquals(userEntity.email, userEntity.email)
        assertEquals(userEntity.phone, userEntity.phone)
        assertEquals(userEntity.website, userEntity.website)
    }

    private fun assertPostDataEquality(userEntity: UserEntity, user: User) {
        assertEquals(userEntity.userId, user.userId)
        assertEquals(userEntity.name, user.name)
        assertEquals(userEntity.email, user.email)
        assertEquals(userEntity.phone, user.phone)
        assertEquals(userEntity.website, user.website)

    }
}