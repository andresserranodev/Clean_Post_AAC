package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzle.bench.post_aac.data.DataSourcePost
import com.puzzle.bench.post_aac.model.Post
import kotlinx.coroutines.launch

class AllPostViewModel internal constructor(private val dataSourcePost: DataSourcePost) :
    ViewModel() {
    private val postLiveData = MutableLiveData<List<Post>>()


    fun getAllPost() {
        viewModelScope.launch {
            postLiveData.postValue(dataSourcePost.getAllPost())
        }
    }

    fun getPostLiveData() = postLiveData

}