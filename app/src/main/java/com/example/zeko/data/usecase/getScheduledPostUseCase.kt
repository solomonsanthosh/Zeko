package com.example.zeko.data.usecase

import com.example.zeko.data.model.Post
import com.example.zeko.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class getScheduledPostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(time:Long): Post? = postRepository.getScheduledPost(time = time)
}