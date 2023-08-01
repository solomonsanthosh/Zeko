package com.example.zeko.data.api

import com.example.zeko.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostService {


    @GET("posts")
    suspend fun getPosts():Response<List<Post>>

    @POST("post")
    suspend fun savePost(@Body post: Post): Response<Post>


}