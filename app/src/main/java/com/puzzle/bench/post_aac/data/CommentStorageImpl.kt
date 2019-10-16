package com.puzzle.bench.post_aac.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.puzzle.bench.post_aac.data.database.dao.CommentDao
import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.model.Comment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommentStorageImpl(private val commentDao: CommentDao, private val mapper: CommentMapper) {

    fun getCommentsByPostId(postId: Int): LiveData<List<Comment>> {
        return Transformations.map(commentDao.getCommentsByPostId(postId)) { commentsEntity ->
            commentsEntity.map {
                mapper.transformEntityToPresentation(it)
            }
        }
    }

    suspend fun insertAll(comments: List<CommentEntity>)= withContext(Dispatchers.IO) {
        commentDao.insertAll(comments)
    }

    companion object {
        @Volatile
        private var instance: CommentStorageImpl? = null

        fun getInstance(commentDao: CommentDao, mapper: CommentMapper) =
            instance ?: synchronized(this) {
                instance
                    ?: CommentStorageImpl(
                        commentDao,
                        mapper
                    ).also { instance = it }
            }
    }
}