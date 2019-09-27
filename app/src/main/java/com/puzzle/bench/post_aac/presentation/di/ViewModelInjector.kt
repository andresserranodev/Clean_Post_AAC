package com.puzzle.bench.post_aac.presentation.di

import android.content.Context
import com.puzzle.bench.post_aac.data.*
import com.puzzle.bench.post_aac.data.database.room.PostAACRoomDatabase
import com.puzzle.bench.post_aac.data.mapper.CommentMapper
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.data.mapper.UserMapper
import com.puzzle.bench.post_aac.data.networking.retrofit.RetrofitClient
import com.puzzle.bench.post_aac.presentation.viewmodels.factory.AllPostViewModelFactory
import com.puzzle.bench.post_aac.presentation.viewmodels.factory.FavoritePostViewModelFactory
import com.puzzle.bench.post_aac.presentation.viewmodels.factory.PostDetailViewModelFactory

object ViewModelInjector {


    private fun providePostStorageImpl(context: Context) = PostStorageImpl.getInstance(
        PostAACRoomDatabase.getInstance(context.applicationContext).postDao(),
        PostMapper()
    )

    private fun provideUserStorageImpl(context: Context) = UserStorageImpl.getInstance(
        PostAACRoomDatabase.getInstance(context.applicationContext).userDao(),
        UserMapper()
    )

    private fun provideCommentStorageImpl(context: Context) = CommentStorageImpl.getInstance(
        PostAACRoomDatabase.getInstance(context.applicationContext).commentDao(),
        CommentMapper()
    )

    private fun provideFetchCommentByPostId() = FetchCommentByPostIdImpl(
        RetrofitClient.makeServiceApi(),
        CommentMapper()
    )

    fun provideAllPostViewModel(context: Context) =
        AllPostViewModelFactory(
            providePostStorageImpl(context)
        )


    fun provideFavoritePostViewModel(context: Context) =
        FavoritePostViewModelFactory(
            providePostStorageImpl(context)
        )

    fun providePostDetailsViewModel(context: Context, postId: Int, userId: Int) =
        PostDetailViewModelFactory(
            providePostStorageImpl(context),
            provideUserStorageImpl(context),
            provideCommentStorageImpl(context),
            provideFetchCommentByPostId(),
            postId,
            userId
        )

}