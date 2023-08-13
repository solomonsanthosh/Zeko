package com.example.zeko.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zeko.R
import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.PostEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.viewmodel.PostViewModel
import com.example.zeko.viewmodel.UserViewModel


@Composable
fun CommentAddScreen(
    viewModel: PostViewModel,
    data: PostEntity?,
    navController: NavController,
    authViewModel: UserViewModel
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit){
        focusRequester.requestFocus()
    }

    var content by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Column(modifier = Modifier.padding(25.dp)) {
            TopAppBar(

                title = { Text(text = "", color = Color.Black) },
                backgroundColor = Color.Black,
                elevation = 0.dp,
                actions = {
                    Button(
                        onClick = {
                            if (data != null) {
                                viewModel.saveComment( data.id,
                                    CommentEntity(
                                        data.id,
                                        authViewModel.userLiveData.value!!,
                                        content
                                    )
                                ).also {
                                    navController.popBackStack()
                                }
                            }

                        }, elevation = ButtonDefaults.elevation(Dp.Hairline),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Yellow,
                            contentColor = Color.Black
                        )

                    ) {
                        Text(text = "Reply")
                    }
                }
            )
            if (data != null) {
                Text(text = "(${data.user.name})",

                    color = Color.Yellow,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp)
                Text( text = data.title,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 5.dp),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Medium)
                Text(  text = data.content,
                    color = colorResource(id = R.color.content),
                    modifier = Modifier.padding(top = 5.dp))
            }
            TextField(value = content,
                onValueChange = { newContent -> content = newContent },
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .focusRequester(focusRequester),
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor = Color.LightGray,
                    textColor = Color.White,
                    backgroundColor = Color.Black,
                    focusedIndicatorColor = Color.DarkGray
                ),
                placeholder = {
                    Text(
                        text = "comment here..."
                    )
                },
                label = {
                    Text(text = "Add Comment", color = Color.DarkGray)
                }
            )
        }


    }


}