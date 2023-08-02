package com.example.zeko.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.zeko.view.ui.theme.ZekoTheme
import com.example.zeko.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.view.screens.CommentAddScreen
import com.example.zeko.view.screens.PostAddScreen
import com.example.zeko.view.screens.PostListScreen
import com.example.zeko.view.screens.PostSingleScreen


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
                            composable(route = ScreenRoute.CommentAddScreen.route) {
                                val data = navController.previousBackStackEntry?.savedStateHandle?.get<PostEntity>("post")
                                CommentAddScreen(viewModel,data,navController)
                            }
                            composable(route = ScreenRoute.PostSingleScreen.route) {
                                val data = navController.previousBackStackEntry?.savedStateHandle?.get<PostEntity>("post")
                                PostSingleScreen(data)
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