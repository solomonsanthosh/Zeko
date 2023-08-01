package com.example.zeko.data.datasource

import com.example.zeko.data.model.Post

interface PostLocalDataSource {

    suspend fun savePostToLocal(post: Post)


    fun getPostFromLocal(time: Long): Post



}