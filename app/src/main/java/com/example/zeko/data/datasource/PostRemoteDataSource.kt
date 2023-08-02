package com.example.zeko.data.datasource

import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import retrofit2.Response

interface PostRemoteDataSource {

    suspend fun savePostToApi(post: PostLocalEntity):Response<PostLocalEntity>

    suspend fun saveCommentToApi(commentEntity: CommentEntity):Response<CommentEntity?>


    suspend fun getPostsFromApi(): Response<List<PostEntity>>

}