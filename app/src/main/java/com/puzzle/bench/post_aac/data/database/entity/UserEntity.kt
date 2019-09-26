package com.puzzle.bench.post_aac.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey var userId: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String
)