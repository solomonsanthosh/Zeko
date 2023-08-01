package com.example.zeko.data.usecase

import com.example.zeko.data.model.Post
import com.example.zeko.data.repository.PostRepository

class scedulePostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(post: Post) = postRepository.scedulePost(post = post)
}