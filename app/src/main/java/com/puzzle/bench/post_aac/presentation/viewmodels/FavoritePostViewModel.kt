package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.puzzle.bench.post_aac.data.PostStorageImpl

class FavoritePostViewModel internal constructor(
    postStorageImpl: PostStorageImpl
) : ViewModel() {
    val allFavoritePostLiveData = postStorageImpl.getAllFavoritePost()
}