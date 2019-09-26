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

    @Query("SELECT * from post_table WHERE idPost = :idPost")
    suspend fun getPostById(idPost: Int): PostEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(post: List<PostEntity>)

    @Query("DELETE FROM post_table")
    suspend fun deleteAll()

    @Query("UPDATE post_table SET wasRead = :wasRead WHERE idPost = :idPost")
    suspend fun updateWasRead(idPost: Int, wasRead: Boolean)

    @Query("UPDATE post_table SET isFavorite = :isFavorite WHERE idPost = :idPost")
    suspend fun updateIsFavorite(idPost: Int, isFavorite: Boolean)
}