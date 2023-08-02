package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class getPostsUseCase(private val postRepository: PostRepository) {

    suspend fun execute(): Flow<List<PostEntity>> = postRepository.getPosts()
}