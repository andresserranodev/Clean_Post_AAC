package com.puzzle.bench.post_aac.data

import com.puzzle.bench.post_aac.data.database.entity.UserEntity

interface FetchAllUsersService {
    suspend fun fetchAllUsers(): List<UserEntity>
}