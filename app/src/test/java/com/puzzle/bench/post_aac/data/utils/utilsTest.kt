package com.puzzle.bench.post_aac.data.utils

import com.puzzle.bench.post_aac.data.utils.utils.BusinesRulesSynPost.getReadPosts
import com.puzzle.bench.post_aac.data.utils.utils.BusinesRulesSynPost.getUnReadPosts
import com.puzzle.bench.post_aac.utils.MockData.Factory.getDummyListPostEntity
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class utilsTest {

    private val dummyEntityResponse = getDummyListPostEntity()

    @Test
    fun getUnReadPosts() {
        utils()
        val unReadPostsResult = getUnReadPosts(dummyEntityResponse)
        assertTrue(unReadPostsResult.size == MAX_POST_UNREADED)
        unReadPostsResult.forEach {
            assertFalse(it.wasRead)
        }
    }

    @Test
    fun getReadPosts() {
        utils()
        val readPostsResult = getReadPosts(dummyEntityResponse)
        assertTrue(readPostsResult.size == 80)
        readPostsResult.forEach {
            assertTrue(it.wasRead)
        }

    }


}