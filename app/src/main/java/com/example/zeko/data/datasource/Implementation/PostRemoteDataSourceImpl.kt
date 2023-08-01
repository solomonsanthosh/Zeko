package com.example.zeko.data.datasource.Implementation

import android.util.Log
import com.example.zeko.data.api.PostService
import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.datasource.PostRemoteDataSource
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class PostRemoteDataSourceImpl(private val postService: PostService) : PostRemoteDataSource {
    override suspend fun savePostToApi(post: Post):Response<Post> {

           return postService.savePost(post)


    }

    override suspend fun getPostsFromApi(): Response<List<Post>> {

        return postService.getPosts()
    }


}