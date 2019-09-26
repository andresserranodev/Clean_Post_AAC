package com.puzzle.bench.post_aac.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.puzzle.bench.post_aac.SycDataWorker
import com.puzzle.bench.post_aac.data.database.dao.CommentDao
import com.puzzle.bench.post_aac.data.database.dao.PostDao
import com.puzzle.bench.post_aac.data.database.dao.UserDao
import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.database.entity.UserEntity

const val DATABASE_NAME = "post-aac-db"

@Database(entities = [PostEntity::class, UserEntity::class, CommentEntity::class], version = 1)
abstract class PostAACRoomDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
    abstract fun commentDao(): CommentDao


    companion object {
        @Volatile
        private var instance: PostAACRoomDatabase? = null

        fun getInstance(context: Context): PostAACRoomDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PostAACRoomDatabase {
            return Room.databaseBuilder(context, PostAACRoomDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SycDataWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }
    }
}