package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puzzle.bench.post_aac.data.DataSourceAllPost

@Suppress("UNCHECKED_CAST")
class AllPostViewModelFactory(private val dataSourceAllPost: DataSourceAllPost) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        AllPostViewModel(dataSourceAllPost) as T
}