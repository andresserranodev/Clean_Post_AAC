package com.puzzle.bench.post_aac.presentation.di

import com.puzzle.bench.post_aac.data.DataSourceAllPostImpl
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModelFactory

object ViewModelInjector {

    private fun getAllPost() = DataSourceAllPostImpl()

    fun provideAllPostViewModel() = AllPostViewModelFactory(getAllPost())
}