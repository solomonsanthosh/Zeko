package com.example.zeko.data.datasource

import com.example.zeko.data.model.PostLocalEntity

interface PostLocalDataSource {

    suspend fun savePostToLocal(post: PostLocalEntity)


    fun getPostFromLocal(beforetime:Long,time: Long): PostLocalEntity



    suspend fun getPostsOffline(): List<PostLocalEntity>



    suspend fun deleteFromOffline(id:Int)

}