package com.example.zeko.viewmodel

import android.app.Application
import android.content.Context

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeko.data.model.Post
import com.example.zeko.data.model.User
import com.example.zeko.data.usecase.getPostsUseCase
import com.example.zeko.data.usecase.savePostUseCase
import com.example.zeko.data.usecase.scedulePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(
    private val savePostUseCase: savePostUseCase,
    private val getPostsUseCase: getPostsUseCase,
    private val scedulePostUseCase: scedulePostUseCase,
    val context: Application
) : ViewModel() {




    private val _posts = MutableStateFlow<MutableList<Post>>(mutableListOf())
    val posts: StateFlow<List<Post>> get() = _posts


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

    fun savePost(post: Post) {
        viewModelScope.launch {
            savePostUseCase.execute(post).also {
                getPosts()
            }

        }
    }


    //sceduling
    fun scedulePost(post: Post) {
        viewModelScope.launch {
            scedulePostUseCase.execute(post)
        }
    }


}