package com.example.zeko.data.repository

import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): Flow<List<PostEntity>>
    suspend fun getMyPosts(id:String): Flow<List<PostEntity>>

    suspend fun getMyComments(id:String): Flow<List<CommentEntity>>
    suspend fun getPostsFromFollowing(id:String): Flow<List<PostEntity>>
    suspend fun savePosts(post: PostLocalEntity): PostLocalEntity?

    suspend fun saveComment(commentEntity: CommentEntity): CommentEntity?
    suspend fun scedulePost(post: PostLocalEntity)
    suspend fun getScheduledPost(time:Long):PostLocalEntity?





}