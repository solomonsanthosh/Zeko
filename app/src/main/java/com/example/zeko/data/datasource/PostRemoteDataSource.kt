package com.example.zeko.data.datasource

import com.example.zeko.data.model.Post
import retrofit2.Response

interface PostRemoteDataSource {

    suspend fun savePostToApi(post: Post):Response<Post>


    suspend fun getPostsFromApi(): Response<List<Post>>

}