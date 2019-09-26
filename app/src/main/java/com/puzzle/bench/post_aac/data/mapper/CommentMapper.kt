package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.networking.responses.CommentsResponse
import com.puzzle.bench.post_aac.model.Comment

class CommentMapper : BaseMapperData<CommentsResponse, CommentEntity, Comment> {

    override fun transformServiceToEntity(service: CommentsResponse) =
        CommentEntity(service.commentId, service.postId, service.body)

    override fun transformEntityToPresentation(entity: CommentEntity) =
        Comment(entity.commentId, entity.postId, entity.body.capitalize())
}