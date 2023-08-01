package com.example.zeko.data.datasource.Implementation

import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostLocalDataSourceImpl(private val postDao: PostDao) : PostLocalDataSource {


    override suspend fun savePostToLocal(post: Post) {
        postDao.savePost(post)

    }

    override fun getPostFromLocal(time: Long): Post {
        return postDao.getPost(time)
    }


}