package com.puzzle.bench.post_aac.data.networking.mapper

import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.model.Post
import kotlin.random.Random

class PostMapperService : BaseMapperService<PostResponse, Post> {

    override fun transformPresentation(serviceModel: PostResponse) = Post(
        serviceModel.userId, serviceModel.postId,
        serviceModel.title, serviceModel.body,
        Random.nextBoolean(),
        Random.nextBoolean()
    )

    override fun transformToResponse(presentationModel: Post) = PostResponse(
        presentationModel.userId, presentationModel.postId,
        presentationModel.title, presentationModel.body
    )
}