package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository

class scedulePostUseCase(private val postRepository: PostRepository) {

    suspend fun execute(post: PostLocalEntity) = postRepository.scedulePost(post = post)
}