package com.example.zeko.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.model.User
import com.example.zeko.data.usecase.getPostsUseCase
import com.example.zeko.data.usecase.saveCommentUseCase
import com.example.zeko.data.usecase.savePostUseCase
import com.example.zeko.data.usecase.scedulePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(
    private val savePostUseCase: savePostUseCase,
    private val getPostsUseCase: getPostsUseCase,
    private val scedulePostUseCase: scedulePostUseCase,
    private val saveCommentUseCase: saveCommentUseCase,
    val context: Application
) : ViewModel() {




    private val _posts = MutableStateFlow<MutableList<PostEntity>>(mutableListOf())
    val posts: StateFlow<List<PostEntity>> get() = _posts




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


    fun getUser(): User? {


        val name = usersharedPref.getString("name", "")
        val email = usersharedPref.getString("email", "")

        val user = if (name!!.length > 0 && email!!.length > 0) {
            User(name, email)
        } else {
            null
        }
        return user


    }

    fun saveUser(user: User): String {

        try {

            val editor = usersharedPref.edit()
            editor.putString("name", user.name)
            editor.putString("email", user.email)
            editor.apply()

        } catch (e: Exception) {
            return e.localizedMessage ?: "Error"
        }
        return "Credentials saved successfully"


    }

    fun savePost(post: PostLocalEntity) {
        viewModelScope.launch {
            savePostUseCase.execute(post).also {
                getPosts()
            }

        }
    }

    fun saveComment(postId:String,commentEntity: CommentEntity) {
        viewModelScope.launch {
            val res = saveCommentUseCase.execute(commentEntity)
            val posts = _posts.value
            val postToUpdate = posts.find { it.id == postId }
            postToUpdate?.let {
                val comments = it.comments.toMutableList()
                comments.add(res!!)
                it.comments = comments.toList()
            }
//
            Log.d("FinalComment",res.toString())
//        posts[index] = postToUpdate!!

            _posts.value = posts
        }

    }


    //sceduling
    fun scedulePost(post: PostLocalEntity) {
        viewModelScope.launch {
            scedulePostUseCase.execute(post)
        }
    }


    fun updateComment(postId: String) {


    }




}