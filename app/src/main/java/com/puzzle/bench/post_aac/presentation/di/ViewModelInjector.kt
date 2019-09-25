package com.puzzle.bench.post_aac.presentation.di

import com.puzzle.bench.post_aac.data.DataSourcePostImpl
import com.puzzle.bench.post_aac.data.networking.RetrofitClient.Factory.makeServiceApi
import com.puzzle.bench.post_aac.data.networking.mapper.PostMapperService
import com.puzzle.bench.post_aac.presentation.viewmodels.AllPostViewModelFactory

object ViewModelInjector {

    private fun getAllPost() = DataSourcePostImpl(makeServiceApi(), PostMapperService())

    fun provideAllPostViewModel() = AllPostViewModelFactory(getAllPost())
}