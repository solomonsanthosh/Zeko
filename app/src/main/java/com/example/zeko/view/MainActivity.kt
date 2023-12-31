package com.example.zeko.view

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box



import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zeko.view.ui.theme.ZekoTheme
import com.example.zeko.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.zeko.data.model.PostEntity
import com.example.zeko.utils.receiver.NetworkCheckReceiver
import com.example.zeko.utils.receiver.NetworkChecker
import com.example.zeko.view.screens.CommentAddScreen
import com.example.zeko.view.screens.PostAddScreen
import com.example.zeko.view.screens.PostListScreen
import com.example.zeko.view.screens.PostSingleScreen
import com.example.zeko.view.screens.account.AccountScreen
import com.example.zeko.view.screens.account.ContactListScreen
import com.example.zeko.view.screens.account.FollowersListScreen
import com.example.zeko.view.screens.auth_screens.LoginScreen
import com.example.zeko.viewmodel.UserViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val networkChecker =NetworkChecker(this)


    private val connectivityReceiver = NetworkCheckReceiver(networkChecker)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerReceiver(connectivityReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        setContent {

            ZekoTheme {



                val navController = rememberNavController()
                val viewModel = hiltViewModel<PostViewModel>()
                val authViewModel = hiltViewModel<UserViewModel>()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var selected by remember {
                        mutableStateOf("Home")
                    }


                    Box(modifier = Modifier.fillMaxWidth()) {
                        NavHost(modifier = Modifier.padding(bottom=56.dp),
                            navController = navController,
                            startDestination = ScreenRoute.LoginScreen.route,

                            ) {

                            //post

                            composable(route = ScreenRoute.PostListScreen.route) {
                                PostListScreen(viewModel, navController = navController,authViewModel)
                            }
                            composable(route = ScreenRoute.PostAddScreen.route) {
                                PostAddScreen(viewModel, navController = navController,authViewModel,networkChecker)
                            }
                            composable(route = ScreenRoute.CommentAddScreen.route) {
                                val data = navController.previousBackStackEntry?.savedStateHandle?.get<PostEntity>("post")
                                CommentAddScreen(viewModel,data,navController,authViewModel)
                            }
                            composable(route = ScreenRoute.PostSingleScreen.route) {
                                val data = navController.previousBackStackEntry?.savedStateHandle?.get<PostEntity>("post")
                                PostSingleScreen(data)
                            }



                            //auth
                            composable(route = ScreenRoute.LoginScreen.route) {

                                LoginScreen(authViewModel,navController)
                            }


                            composable(route = ScreenRoute.AccountScreen.route) {
                                AccountScreen(viewModel, navController = navController,authViewModel)
                            }
                            composable(route = ScreenRoute.FollowersListScreen.route) {
                                FollowersListScreen(navController, authViewModel,type = it.arguments!!.getString("type")!!)
                            }
                            composable(route = ScreenRoute.ContactListScreen.route) {
                                ContactListScreen(authViewModel)
                            }
                        }
                        BottomNavigation(
                            backgroundColor = Color.Black,
                        modifier = Modifier.align(alignment = Alignment.BottomCenter)
                        ) {

                            BottomNavigationItem(selected = selected == "Feed",  onClick = {

                                selected = "Feed"
                                navController.navigate(ScreenRoute.PostListScreen.route)
                            }, icon = {
                                Icon(imageVector = Icons.Default.Send, contentDescription = "Home", tint = if(selected == "Feed") Color.Yellow else Color.White)
                            })

                            BottomNavigationItem(selected = selected == "Profile",  onClick = {
                                selected = "Profile"
                                navController.navigate(ScreenRoute.AccountScreen.route)
                            }, icon = {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Language",
                                    tint = if(selected == "Profile") Color.Yellow else Color.White)
                            })
                        }
                    }


                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityReceiver)
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