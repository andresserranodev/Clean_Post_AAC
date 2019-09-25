package com.puzzle.bench.post_aac.presentation.di

import android.content.Context
import com.puzzle.bench.post_aac.data.database.PostAACRoomDatabase
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.data.mapper.PostMapper
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModelFactory

object ViewModelInjector {
    fun provideAllPostViewModel(context: Context) = AllPostViewModelFactory(
        PostStorageImpl.getInstance(
            PostAACRoomDatabase.getInstance(context.applicationContext).postDao(),
            PostMapper()
        )
    )
}