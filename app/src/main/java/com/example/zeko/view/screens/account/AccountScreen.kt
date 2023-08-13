package com.example.zeko.view.screens.account

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.zeko.view.screens.PostCard
import com.example.zeko.viewmodel.PostViewModel
import com.example.zeko.viewmodel.UserViewModel


@Composable
fun AccountScreen(
    viewModel: PostViewModel,
    navController: NavHostController,
    authViewModel: UserViewModel
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val posts by viewModel.posts.collectAsState(initial = emptyList())
    val comments by viewModel.comments.collectAsState(initial = emptyList())

    val tabs = listOf("Posts", "Comments")

    LaunchedEffect(Unit){

        Log.d("Account",posts.size.toString())
        viewModel.getMyPosts(authViewModel.userLiveData.value!!.id)
    }
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Yellow), contentAlignment = Alignment.Center){
            Text(text = "ZeKo", fontSize = 40.sp, fontWeight = FontWeight.Black, textAlign = TextAlign.Center, letterSpacing = 2.sp, color = Color.Black)

        }
        
        Column(modifier = Modifier
            .fillMaxWidth()

            .background(Color.Black) ){

            Text(text = "@${authViewModel.userLiveData.value!!.name}", color = Color.White, fontWeight = FontWeight.Black, fontSize = 18.sp, modifier = Modifier.padding(top=15.dp, start = 15.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)) {
                Text(text = "${authViewModel.userLiveData.value!!.followers.size} followers", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 15.sp)
                Text(text = "${authViewModel.userLiveData.value!!.following.size} following", color = Color.White, fontWeight = FontWeight.Medium, fontSize = 15.sp, modifier = Modifier.padding(start=10.dp))

            }
            Divider(color = Color.White, thickness = 1.dp)
            ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed{index: Int, s: String ->

                    Tab(
                        selected = index == selectedTabIndex, // Set true for the initially selected tab
                        onClick = {
                            selectedTabIndex = index

                            when(index){
                                0 -> viewModel.getMyPosts(authViewModel.userLiveData.value!!.id)
                                1 -> viewModel.getMyComments(authViewModel.userLiveData.value!!.id)
                            }




                        },
                        text = { Text(text = s) }
                    )

                }



            }
        }
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .weight(1f)){


            if(selectedTabIndex == 0){
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
                        PostCard(item = item,navController,viewModel,authViewModel)
                    }
                }
            } else {
                if (comments.isEmpty()) {
                    item {

                        Text(
                            text = "No comments to display",
                            color = Color.DarkGray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth()
                        )
                    }
                } else {
                    items(items = comments) { item ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp)
                        ) {


                            Text(
                                text = "(${item.user.name})",

                                color = Color.Yellow,
                                modifier = Modifier.padding(top = 5.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = item.content,
                                color = Color.LightGray,
                                modifier = Modifier.padding(top = 5.dp),
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Medium
                            )


                        }

                    }
                }

            }




        }

    }
}


//@Preview
//@Composable
//fun prev(){
//    AccountScreen()
//}
