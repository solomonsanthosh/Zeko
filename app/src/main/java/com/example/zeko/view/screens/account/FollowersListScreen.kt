package com.example.zeko.view.screens.account

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zeko.view.ScreenRoute
import com.example.zeko.viewmodel.UserViewModel


@Composable
fun FollowersListScreen(
    navController: NavController,
    authViewModel: UserViewModel,
    type: String
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        authViewModel.getFollowings(type)
    }






    val followings by authViewModel.followings.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if(type == "following"){
            TopAppBar(

                title = { Text(text = "", color = Color.Black) },
                backgroundColor = Color.Black,
                elevation = 0.dp,


                actions = {
                    IconButton(onClick = {


                        navController.navigate(ScreenRoute.ContactListScreen.route)

                    }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Follow",
                            tint = Color.White
                        )
                    }
                }
            )
        }

        LazyColumn(
            modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            if (followings == null) {
                item {

                    Text(
                        text = "No followings to display",
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                    )
                }
            } else {


                items(items = followings!!) { item ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Text(
                            text = item.name,
                            color = Color.LightGray,

                            fontSize = 19.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            modifier = Modifier

                                .clickable {

                                    var type2 = "push"
                                    if (authViewModel.userLiveData.value?.id in item.followers) {
                                        type2 = "pull"
                                    }

                                    authViewModel.makeConnection(
                                        item.id,
                                        { authViewModel.getFollowings(type) },
                                        type2
                                    )

                                },
                            text = if (authViewModel.userLiveData.value?.id in item.followers) {
                                "following"
                            } else {
                                "follow"
                            },
                            fontSize = 15.sp,
                            color = Color.LightGray
                        )
                    }
                    Divider(color = Color.DarkGray, thickness = 2.dp)

                }
            }


        }
    }
}