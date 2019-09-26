package com.puzzle.bench.post_aac.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment_table")
data class CommentEntity(
    @PrimaryKey var commentId: Int,
    val postId: Int,
    val body: String
)