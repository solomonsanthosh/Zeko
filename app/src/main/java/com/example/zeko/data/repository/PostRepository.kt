package com.example.zeko.data.repository

import com.example.zeko.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): Flow<List<Post>>
    suspend fun savePosts(post: Post): Post?
    suspend fun scedulePost(post: Post)
    suspend fun getScheduledPost(time:Long):Post?



}