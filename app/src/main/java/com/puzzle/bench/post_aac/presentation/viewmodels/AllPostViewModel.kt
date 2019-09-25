package com.puzzle.bench.post_aac.presentation.viewmodels

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puzzle.bench.post_aac.data.DataSourcePost
import com.puzzle.bench.post_aac.model.Post

class AllPostViewModel internal constructor(private val dataSourcePost: DataSourcePost) :
    ViewModel() {
    private val postLiveData = MutableLiveData<List<Post>>()


    fun getAllPost() {
        Handler().postDelayed({
            postLiveData.postValue(dataSourcePost.getAllPost())
        }, 1000)
    }

    fun getPostLiveData() = postLiveData

}