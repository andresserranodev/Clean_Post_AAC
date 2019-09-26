package com.puzzle.bench.post_aac.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey var idPost: Int,
    val userId: Int,
    val title: String,
    val body: String,
    var wasRead: Boolean,
    val isFavorite: Boolean
)