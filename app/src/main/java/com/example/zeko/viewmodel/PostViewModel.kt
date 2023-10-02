package com.example.zeko.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.usecase.getMyCommentsUseCase
import com.example.zeko.data.usecase.getMyPostsUseCase
import com.example.zeko.data.usecase.getPostFromFollowingUseCase
import com.example.zeko.data.usecase.getPostsUseCase
import com.example.zeko.data.usecase.saveCommentUseCase
import com.example.zeko.data.usecase.savePostUseCase
import com.example.zeko.data.usecase.scedulePostUseCase
import com.example.zeko.utils.notification.NotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(
    private val savePostUseCase: savePostUseCase,
    private val getPostsUseCase: getPostsUseCase,
    private val scedulePostUseCase: scedulePostUseCase,
    private val saveCommentUseCase: saveCommentUseCase,
    private val getPostFromFollowingUseCase: getPostFromFollowingUseCase,
    private val getMyPostsUseCase: getMyPostsUseCase,
    private val getMyCommentsUseCase: getMyCommentsUseCase,
    val notificationService: NotificationService,
    val context: Application
) : ViewModel() {





    private val _posts = MutableStateFlow<MutableList<PostEntity>>(mutableListOf())
    val posts: StateFlow<List<PostEntity>> get() = _posts



    var comments = MutableStateFlow<MutableList<CommentEntity>>(mutableListOf())


    //user
    val usersharedPref = context.getSharedPreferences(
        "user", Context.MODE_PRIVATE
    )

    init {
        getPosts()
    }
    fun getPosts() {
        viewModelScope.launch {
            getPostsUseCase.execute().collect {
                _posts.value = it.toMutableList()
            }
        }
    }

    fun getPostsFromFollowing(id:String) {
        viewModelScope.launch {
            getPostFromFollowingUseCase.execute(id).collect {
                _posts.value = it.toMutableList()
            }
        }

    }

    fun getMyPosts(id:String) {
        Log.d("ID",id)
        viewModelScope.launch {
            getMyPostsUseCase.execute(id).collect {
                _posts.value = it.toMutableList()
            }
        }

    }




    fun savePost(post: PostLocalEntity) {
        viewModelScope.launch {
            savePostUseCase.execute(post).also {
                notificationService.showNotification(post.title)
                getPosts()
            }

        }
    }

    fun saveComment(postId:String,commentEntity: CommentEntity) {
        viewModelScope.launch {
            val res = saveCommentUseCase.execute(commentEntity)
            Log.d("Comment",commentEntity.toString())
            val posts = _posts.value
            val postToUpdate = posts.find { it.id == postId }
            postToUpdate?.let {
                val comments = it.comments.toMutableList()
                comments.add(res!!)
                it.comments = comments.toList()
            }
            Log.d("FinalComment",res.toString())
//        posts[index] = postToUpdate!!

            _posts.value = posts
        }

    }


    //sceduling
    fun savePostToLocal(post: PostLocalEntity) {
        viewModelScope.launch {
            scedulePostUseCase.execute(post)
        }
    }


    fun getMyComments(id: String) {

        viewModelScope.launch {
             getMyCommentsUseCase.execute(id).collect {
               comments.value = it.toMutableList()
           }
        }


    }




}