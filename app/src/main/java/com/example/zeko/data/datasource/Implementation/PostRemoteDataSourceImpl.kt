package com.example.zeko.data.datasource.Implementation

import com.example.zeko.data.api.PostService
import com.example.zeko.data.datasource.PostRemoteDataSource
import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.model.UserEntity
import retrofit2.Response

class PostRemoteDataSourceImpl(private val postService: PostService) : PostRemoteDataSource {
    override suspend fun savePostToApi(post: PostLocalEntity):Response<PostLocalEntity> {

           return postService.savePost(post)


    }

    override suspend fun saveCommentToApi(commentEntity: CommentEntity): Response<CommentEntity?> {
        return postService.saveComment(comment = commentEntity)
    }

    override suspend fun getPostsFromApi(): Response<List<PostEntity>> {

        return postService.getPosts()
    }

    override suspend fun getPostsFromFollowingApi(id:String): Response<List<PostEntity>> {
        return postService.getPostsFromFollowing(id)
    }

    override suspend fun getMyPosts(id: String): Response<List<PostEntity>> {
        return postService.getMyPosts(id)
    }



    override suspend fun getMyComments(id: String): Response<List<CommentEntity>> {
        return postService.getMyComments(id)
    }


}