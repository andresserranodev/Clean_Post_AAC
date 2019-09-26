package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.networking.responses.PostResponse
import com.puzzle.bench.post_aac.model.Post
import java.util.*

class PostMapper : BaseMapperData<PostResponse, PostEntity, Post> {

    override fun transformServiceToEntity(service: PostResponse) =
        PostEntity(
            service.postId, service.userId, service.title, service.body,
            wasRead = false,
            isFavorite = false
        )

    override fun transformEntityToPresentation(entity: PostEntity) = Post(
        entity.idPost,
        entity.userId,
        entity.title,
        entity.body.capitalize(),
        entity.wasRead,
        entity.isFavorite
    )
}