package com.puzzle.bench.post_aac.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puzzle.bench.post_aac.data.database.entity.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * from post_table ORDER BY idPost")
    fun getAllPost(): LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(post: List<PostEntity>)
}