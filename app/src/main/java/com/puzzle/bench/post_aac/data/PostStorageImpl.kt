package com.puzzle.bench.post_aac.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.puzzle.bench.post_aac.data.database.dao.PostDao
import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.model.Post


class PostStorageImpl(
    private val postDao: PostDao,
    private val postMapper: PostMapper
) {

    suspend fun insertAll(postList: List<PostEntity>) {
        postDao.insertAll(postList)
    }

    fun getAllPost(): LiveData<List<Post>> {
        return Transformations.map(postDao.getAllPost()) { postListEntity ->
            postListEntity.map {
                postMapper.transformEntityToPresentation(it)
            }
        }
    }

    companion object {
        @Volatile
        private var instance: PostStorageImpl? = null

        fun getInstance(postDao: PostDao, mapper: PostMapper) =
            instance ?: synchronized(this) {
                instance
                    ?: PostStorageImpl(
                        postDao,
                        mapper
                    ).also { instance = it }
            }
    }
}