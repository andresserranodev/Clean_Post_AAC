package com.puzzle.bench.post_aac.data.utils

import com.puzzle.bench.post_aac.data.database.entity.PostEntity

const val MAX_POST_UNREADED = 20

class utils {

    companion object BusinesRulesSynPost {

        fun getUnReadPosts(serviceRepose: List<PostEntity>): List<PostEntity> {

            return serviceRepose.toMutableList().take(MAX_POST_UNREADED).map {
                it.apply {
                    wasRead = false
                }
            }

        }

        fun getReadPosts(serviceRepose: List<PostEntity>): List<PostEntity> {
            return serviceRepose.toMutableList().subList(20, serviceRepose.size)

        }

    }
}