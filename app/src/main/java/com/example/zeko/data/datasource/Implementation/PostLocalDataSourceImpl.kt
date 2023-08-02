package com.example.zeko.data.datasource.Implementation

import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.model.PostLocalEntity

class PostLocalDataSourceImpl(private val postDao: PostDao) : PostLocalDataSource {


    override suspend fun savePostToLocal(post: PostLocalEntity) {
        postDao.savePost(post)

    }

    override fun getPostFromLocal(timebefore:Long, time: Long): PostLocalEntity {
        return postDao.getPost(timebefore,time)
    }


}