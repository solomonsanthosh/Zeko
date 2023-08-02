package com.example.zeko.data.usecase

import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository

class saveCommentUseCase (private val postRepository: PostRepository) {

    suspend fun execute(commentEntity: CommentEntity): CommentEntity? = postRepository.saveComment(commentEntity)
}
