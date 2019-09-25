package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puzzle.bench.post_aac.data.DataSourcePost

@Suppress("UNCHECKED_CAST")
class AllPostViewModelFactory(private val dataSourcePost: DataSourcePost) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        AllPostViewModel(dataSourcePost) as T
}