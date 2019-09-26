package com.puzzle.bench.post_aac.data.utils

import com.puzzle.bench.post_aac.data.database.entity.PostEntity

class utils {

    companion object BusinesRulesSynPost {

        fun getUnReadPosts(serviceRepose: List<PostEntity>): List<PostEntity> {

            return serviceRepose.toMutableList().take(20).map {
                it.apply {
                    wasRead = false
                }
            }

        }

        fun getReadedPosts(serviceRepose: List<PostEntity>): List<PostEntity> {
            return serviceRepose.toMutableList().subList(20, serviceRepose.size)

        }

    }
}