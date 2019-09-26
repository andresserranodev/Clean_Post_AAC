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

    fun getAllFavPost(): LiveData<List<Post>> {
        return Transformations.map(postDao.getAllFavPost()) { postListEntity ->
            postListEntity.map {
                postMapper.transformEntityToPresentation(it)
            }
        }
    }


    fun getPostById(idPost: Int): LiveData<Post> {
        return Transformations.map(postDao.getPostById(idPost)) {
            postMapper.transformEntityToPresentation(it)
        }
    }

    suspend fun deleteAll() {
        postDao.deleteAll()
    }

    suspend fun deleteByIdPost(idPost: Int) {
        postDao.deleteByIdPost(idPost)
    }

    suspend fun updateWasRead(idPost: Int, wasRead: Boolean) {
        postDao.updateWasRead(idPost, wasRead)
    }

    suspend fun updateIsFavorite(idPost: Int, isFavorite: Boolean) {
        postDao.updateIsFavorite(idPost, isFavorite)
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