package com.puzzle.bench.post_aac.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puzzle.bench.post_aac.data.database.entity.CommentEntity

@Dao
interface CommentDao {

    @Query("SELECT * from comment_table WHERE postId = :idPost")
    fun getCommentsByPostId(idPost: Int): LiveData<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(comments: List<CommentEntity>)
}