package com.example.zeko.data.usecase

import com.example.zeko.data.model.Post
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.implementation.PostRepositoryImpl

class savePostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(post: Post):Post? = postRepository.savePosts(post = post)
}

