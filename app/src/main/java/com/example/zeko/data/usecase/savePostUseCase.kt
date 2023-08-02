package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository

class savePostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(post: PostLocalEntity):PostLocalEntity? = postRepository.savePosts(post = post)
}

