package com.puzzle.bench.post_aac.data.mapper

import com.puzzle.bench.post_aac.data.MockData.Factory.BASE_BODY
import com.puzzle.bench.post_aac.data.database.entity.CommentEntity
import com.puzzle.bench.post_aac.data.database.entity.PostEntity
import com.puzzle.bench.post_aac.data.networking.responses.CommentsResponse
import com.puzzle.bench.post_aac.model.Comment
import com.puzzle.bench.post_aac.model.Post
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CommentMapperTest {

    private lateinit var mapper: CommentMapper
    @Before
    fun setUp() {
        mapper = CommentMapper()
    }

    @Test
    fun transformServiceToEntity() {
        val serviceResponse = CommentsResponse(9, 9, BASE_BODY)
        val result = mapper.transformServiceToEntity(serviceResponse)
        asserDataEquality(serviceResponse, result)
    }

    @Test
    fun transformEntityToPresentation() {
        val mockEntity = CommentEntity(9, 9, BASE_BODY)
        val result = mapper.transformEntityToPresentation(mockEntity)
        assertDataEquality(mockEntity, result)
    }

    private fun asserDataEquality(
        commentsResponse: CommentsResponse,
        commentEntity: CommentEntity
    ) {
        assertEquals(commentsResponse.commentId, commentEntity.commentId)
        assertEquals(commentsResponse.postId, commentEntity.postId)
        assertEquals(commentsResponse.body, commentEntity.body)
    }

    private fun assertDataEquality(commentEntity: CommentEntity, comment: Comment) {
        assertEquals(commentEntity.commentId, comment.commentId)
        assertEquals(commentEntity.postId, comment.postId)
        assertEquals(commentEntity.body, comment.body)

    }
}