package com.example.zeko.view.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit

import androidx.compose.runtime.*
import androidx.navigation.NavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.zeko.data.model.Post
import com.example.zeko.viewmodel.PostViewModel
import java.util.*



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostAddScreen(viewModel: PostViewModel, navController: NavController) {



    var title by remember {
        mutableStateOf("")
    }
    var content by remember {
        mutableStateOf("")
    }

    var pickedTimeInMilli:Long by remember {
        mutableStateOf(0)
    }
    var isScheduled by remember {
        mutableStateOf(false)
    }


    var showDialog by remember { mutableStateOf(false) }


//    LaunchedEffect(isScheduled){
//
//        showDialog = false
//
//    }
fun ScdeduledSubmit(){

    Log.d("Time",pickedTimeInMilli.toString())

    if(title.length > 0 && content.length>0){
        viewModel.scedulePost(Post(0,viewModel.getUser()!!.name,title,content,pickedTimeInMilli))

    }

}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        val modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 15.dp, end = 15.dp)

        Text(
            text = "Add a post",
            modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 15.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Black,
            color = Color.White
        )


        TextField(value = title,
            onValueChange = { newTitle -> title = newTitle },
            modifier = modifier,
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.LightGray,
                textColor = Color.White,
                backgroundColor = Color.Black,
                focusedIndicatorColor = Color.DarkGray

            ),
            placeholder = {
                Text(
                    text = "post title..."
                )
            },
            label = {
                Text(text = "Title", color = Color.DarkGray)
            }
        )
        TextField(value = content,
            onValueChange = { newContent -> content = newContent },
            modifier = modifier.height(200.dp),
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.LightGray,
                textColor = Color.White,
                backgroundColor = Color.Black,
                focusedIndicatorColor = Color.DarkGray
            ),
            placeholder = {
                Text(
                    text = "post content..."
                )
            },
            label = {
                Text(text = "Content", color = Color.DarkGray)
            }
        )

        Row() {
            Button(
                colors = ButtonDefaults.buttonColors(
                    disabledBackgroundColor = Color.LightGray,
                    backgroundColor = Color.White,
                    contentColor = Color.Black

                ),
                enabled = !title.isNullOrEmpty(),
                onClick = {

                    viewModel.savePost(
                        Post(
                            0,
                            viewModel.getUser()!!.name,
                            title,
                            content,
                            System.currentTimeMillis()
                        )
                    )
                    navController.popBackStack()


                }, modifier = Modifier.padding(
                    15.dp
                )
            ) {
                Text(text = "Add Log")
            }
            IconButton(
                onClick = { showDialog = true },
//                viewModel.scedulePost(Post(0,viewModel.getUser()!!.name, title,content,System.currentTimeMillis()))
            ) {

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.White
                )

            }

        }
        if (showDialog) {
            // Call the custom Popup composable to create the overlay
            SchedulePostPopup(
                onDismissRequest = { showDialog = false },  onTimeSelected = { updatedTime ->
                    pickedTimeInMilli = updatedTime
                },
                onScheduled = ::ScdeduledSubmit
            )
        }

    }


}




