package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.utils.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.rules.TestRule

class AllPostViewModelTest {


    private val postStorageImpl = mock<PostStorageImpl>()

    private lateinit var allPostViewModel: AllPostViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()


    @Before
    fun setUp() {
        allPostViewModel = AllPostViewModel(postStorageImpl)
    }



    @ExperimentalCoroutinesApi
    @Test
    fun deleteAll() {
        allPostViewModel.deleteAll()
        runBlocking {
            verify(postStorageImpl).deleteAll()
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun deletePost() {
        allPostViewModel.deletePost(1)
        runBlocking {
            verify(postStorageImpl).deleteByIdPost(1)

        }
    }


}