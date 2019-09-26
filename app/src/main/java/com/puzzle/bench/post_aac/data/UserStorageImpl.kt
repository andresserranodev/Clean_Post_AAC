package com.puzzle.bench.post_aac.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.puzzle.bench.post_aac.data.database.dao.PostDao
import com.puzzle.bench.post_aac.data.database.dao.UserDao
import com.puzzle.bench.post_aac.data.database.entity.UserEntity
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.data.mapper.UserMapper
import com.puzzle.bench.post_aac.model.User

class UserStorageImpl(private val userDao: UserDao, private val userMapper: UserMapper) {

    fun getUserById(userId: Int): LiveData<User> {
        return Transformations.map(userDao.getUserById(userId)) {
            userMapper.transformEntityToPresentation(it)
        }
    }

    suspend fun insertAll(user: List<UserEntity>) {
        userDao.insertAll(user)
    }

    companion object {
        @Volatile
        private var instance: UserStorageImpl? = null

        fun getInstance(userDao: UserDao, mapper: UserMapper) =
            instance ?: synchronized(this) {
                instance
                    ?: UserStorageImpl(
                        userDao,
                        mapper
                    ).also { instance = it }
            }
    }
}