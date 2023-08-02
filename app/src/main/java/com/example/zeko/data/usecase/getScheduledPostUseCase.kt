package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository

class getScheduledPostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(time:Long): PostLocalEntity? = postRepository.getScheduledPost(time = time)
}