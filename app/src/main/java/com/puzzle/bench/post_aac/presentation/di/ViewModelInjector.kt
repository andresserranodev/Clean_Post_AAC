package com.puzzle.bench.post_aac.presentation.di

import com.puzzle.bench.post_aac.data.DataSourcePostImpl
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModelFactory

object ViewModelInjector {

    private fun getAllPost() = DataSourcePostImpl()

    fun provideAllPostViewModel() = AllPostViewModelFactory(getAllPost())
}