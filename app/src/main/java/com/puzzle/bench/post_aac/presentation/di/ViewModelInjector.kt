package com.puzzle.bench.post_aac.presentation.di

import android.content.Context
import com.puzzle.bench.post_aac.data.database.PostAACRoomDatabase
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModelFactory
import com.puzzle.bench.post_aac.presentation.viewmodels.PostDetailViewModel
import com.puzzle.bench.post_aac.presentation.viewmodels.PostDetailViewModelFactory

object ViewModelInjector {


    private fun providePostStorageImpl(context: Context) = PostStorageImpl.getInstance(
        PostAACRoomDatabase.getInstance(context.applicationContext).postDao(),
        PostMapper()
    )

    fun provideAllPostViewModel(context: Context) =
        AllPostViewModelFactory(providePostStorageImpl(context))

    fun providePostDetailsViewModel(context: Context, postId: Int) = PostDetailViewModelFactory(
        providePostStorageImpl(context), postId
    )

}