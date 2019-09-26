package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.UserEntity
import com.puzzle.bench.post_aac.data.mapper.UserMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.JsonPlaceholderApi

class FetchAllUsersServiceImpl(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val userMapper: UserMapper
) : FetchAllUsersService {
    override suspend fun fetchAllUsers(): List<UserEntity> {
        return jsonPlaceholderApi.getAllUsersRequest().map {
            userMapper.transformServiceToEntity(it)
        }
    }
}