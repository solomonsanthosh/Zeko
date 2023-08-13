package com.example.zeko.data.api

import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {


    @GET("posts")
    suspend fun getPosts():Response<List<PostEntity>>
    @GET("post/following/{id}")
    suspend fun getPostsFromFollowing(@Path("id") id:String):Response<List<PostEntity>>


    @GET("comments/{id}")
    suspend fun getMyComments(@Path("id") id:String):Response<List<CommentEntity>>


    @GET("posts/{id}")
    suspend fun getMyPosts(@Path("id") id:String):Response<List<PostEntity>>

    @POST("post")
    suspend fun savePost(@Body post: PostLocalEntity): Response<PostLocalEntity>

    @POST("comment")
    suspend fun saveComment(@Body comment: CommentEntity): Response<CommentEntity?>


}