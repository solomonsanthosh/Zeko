package com.example.zeko.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.zeko.view.ui.theme.ZekoTheme
import com.example.zeko.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zeko.data.model.Post
import com.example.zeko.data.model.User
import com.example.zeko.view.ScreenRoute
import com.example.zeko.view.screens.PostAddScreen
import com.example.zeko.view.screens.PostListScreen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ZekoTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<PostViewModel>()
//                viewModel.getPosts()

//                Log.d("User",viewModel.saveUser(User("santy", "solosanty2064@gmail.com")))
//                Log.d("User",viewModel.getUser().toString())

//                viewModel.savePost(Post(0,viewModel.getUser()!!.name,"first one","first description",55))
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        NavHost(
                            navController = navController,
                            startDestination = ScreenRoute.PostListScreen.route,

                            ) {
                            composable(route = ScreenRoute.PostListScreen.route) {
                                PostListScreen(viewModel, navController = navController)
                            }
                            composable(route = ScreenRoute.PostAddScreen.route) {
                                PostAddScreen(viewModel, navController = navController)
                            }
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZekoTheme {
        Greeting("Android")
    }
}