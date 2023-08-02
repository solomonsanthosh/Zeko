package com.example.zeko.data.repository.implementation

import android.app.Application
import android.util.Log
import androidx.work.*
import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.datasource.PostRemoteDataSource
import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.worker.ScheduledPostWorker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.TimeUnit


class PostRepositoryImpl(
    private val postRemoteDataSource: PostRemoteDataSource,
    private val postLocalDataSource: PostLocalDataSource,
    private val context:Application
) : PostRepository {

    override suspend fun getPosts(): Flow<List<PostEntity>> = flow {


        try {
            val response = postRemoteDataSource.getPostsFromApi()
            val body = response.body()
            if (body != null) {
                Log.d("Flow", body.toString())
                emit(body)
            }

        } catch (exception: java.lang.Exception) {
            emit(emptyList())
        }


    }.flowOn(Dispatchers.IO)


    override suspend fun savePosts(post: PostLocalEntity): PostLocalEntity? {


        var postResult: PostLocalEntity? = null
        try {
            val response = postRemoteDataSource.savePostToApi(post)
            val body = response.body()
            postResult = if (body != null) {

                body
            } else {
                null
            }

        } catch (exception: java.lang.Exception) {
            return null
        }

        return postResult

    }

    override suspend fun saveComment(commentEntity: CommentEntity): CommentEntity? {
        var result: CommentEntity? = null
        try {
            val response = postRemoteDataSource.saveCommentToApi(commentEntity)
            val body = response.body()
            result = if (body != null) {

                body
            } else {
                null
            }

        } catch (exception: java.lang.Exception) {
            return null
        }

        return result

    }


    override suspend fun scedulePost(post: PostLocalEntity) {

        postLocalDataSource.savePostToLocal(post).also {

            val timeDelayMillis  = post.created_at - System.currentTimeMillis()
            Log.d("TimeD",timeDelayMillis.toString())
            val constraints  = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val workRequest = OneTimeWorkRequestBuilder<ScheduledPostWorker>().setConstraints(constraints).setInitialDelay(timeDelayMillis,TimeUnit.MILLISECONDS).build()

            WorkManager.getInstance(context.applicationContext).enqueueUniqueWork(post.created_at.toString(),ExistingWorkPolicy.APPEND,workRequest)        }


    }

    override suspend fun getScheduledPost(time: Long): PostLocalEntity? {
        var post: PostLocalEntity? = null
        try {

            val beforetime = time - 1000 * 60 * 2

            post = postLocalDataSource.getPostFromLocal(beforetime,time)
            return post
        } catch (e: Exception) {
           return null
        }

    }


}