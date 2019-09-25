package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.*
import com.puzzle.bench.post_aac.data.PostStorageImpl

class AllPostViewModel internal constructor(
    private val postStorageImpl: PostStorageImpl
) :
    ViewModel() {
        fun fetchAllPost() = postStorageImpl.getAllPost()
}