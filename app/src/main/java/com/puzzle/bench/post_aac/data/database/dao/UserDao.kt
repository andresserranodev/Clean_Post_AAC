package com.puzzle.bench.post_aac.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puzzle.bench.post_aac.data.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * from user_table WHERE userId = :userId")
    fun getUserById(userId: Int): LiveData<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<UserEntity>)
}