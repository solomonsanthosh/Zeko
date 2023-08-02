package com.example.zeko.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zeko.view.ScreenRoute
import com.example.zeko.viewmodel.PostViewModel


@Composable
fun PostListScreen(viewModel: PostViewModel, navController: NavController) {


    val posts by viewModel.posts.collectAsState(initial = emptyList())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopAppBar(

            title = { Text(text = "Logger", color = Color.Black) },
            backgroundColor = Color.Black,
            elevation = 0.dp,

            actions = {
                IconButton(onClick = {

                    navController.navigate(ScreenRoute.PostAddScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .weight(1f)
        ) {


            if (posts.isEmpty()) {
                item {

                    Text(
                        text = "No posts to display",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                    )
                }
            } else {
                items(items = posts) { item ->
                    PostCard(item = item,navController)
                }
            }

        }


    }
}
