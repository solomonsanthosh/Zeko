package com.example.zeko.view.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeko.R

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.viewmodel.PostViewModel
import com.example.zeko.viewmodel.UserViewModel
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostAddScreen(
    viewModel: PostViewModel,
    navController: NavController,
    authViewModel: UserViewModel,
) {

    val context = LocalContext.current

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



fun ScdeduledSubmit(){



    if(title.length > 0 && content.length>0){
        viewModel.scedulePost(PostLocalEntity(0,authViewModel.userLiveData.value!!.id,title,content,pickedTimeInMilli)).also {
            Toast.makeText(context,"Post scheduled successfully",Toast.LENGTH_LONG).show()

            navController.popBackStack()
        }


    } else {
        Toast.makeText(context,"Please enter the content of post",Toast.LENGTH_LONG).show()
    }

}

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        val modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 15.dp, end = 15.dp)

        Column() {
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
        }


        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(
                13.dp
            ), verticalAlignment = Alignment.CenterVertically) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    disabledBackgroundColor = Color.LightGray,
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Black

                ),
                shape = RoundedCornerShape(20.dp)
                ,
                enabled = !title.isNullOrEmpty() && !content.isNullOrEmpty(),
                onClick = {


                    viewModel.savePost(
                        PostLocalEntity(
                            0,
                            authViewModel.userLiveData.value!!.id,
                            title,
                            content,
                            System.currentTimeMillis()
                        )
                    )
                    navController.popBackStack()


                }, modifier = Modifier
                    .padding(end = 7.dp)

                    .weight(.8f, fill = true)
            ) {
                Text(text = "Add Log")
            }
            Button(onClick = {
            showDialog = true
            },shape = RoundedCornerShape(20.dp) ,elevation = ButtonDefaults.elevation(defaultElevation = 5.dp), colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Yellow
            )) {
                Image(
                    painterResource(R.drawable.schedule),
                    contentDescription = "comment",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(18.dp)
//                        .weight(.2f, fill = true)
//                    .clickable {
//                        navController.currentBackStackEntry?.savedStateHandle?.set("post", item)
//                        navController.navigate(ScreenRoute.CommentAddScreen.route)
//                    }
                )
            }

//            IconButton(
//                onClick = { showDialog = true },
////                viewModel.scedulePost(Post(0,viewModel.getUser()!!.name, title,content,System.currentTimeMillis()))
//            ) {
//
//                Icon(
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "Edit",
//                    tint = Color.White
//                )
//
//            }


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




