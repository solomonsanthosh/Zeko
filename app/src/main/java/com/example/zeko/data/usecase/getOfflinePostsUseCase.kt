package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository

class getOfflinePostsUseCase(private val postRepository: PostRepository) {
    suspend fun execute():List<PostLocalEntity>? = postRepository.getPostsOffline()
}