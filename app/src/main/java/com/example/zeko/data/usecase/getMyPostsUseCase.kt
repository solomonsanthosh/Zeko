package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class getMyPostsUseCase(private val postRepository: PostRepository) {

    suspend fun execute(id:String): Flow<List<PostEntity>> = postRepository.getMyPosts(id)
}