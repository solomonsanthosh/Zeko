package com.example.zeko.data.usecase

import com.example.zeko.data.model.Post
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.implementation.PostRepositoryImpl
import kotlinx.coroutines.flow.Flow

class getPostsUseCase(private val postRepository: PostRepository) {

    suspend fun execute(): Flow<List<Post>> = postRepository.getPosts()
}