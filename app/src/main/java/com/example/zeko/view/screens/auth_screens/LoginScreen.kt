package com.example.zeko.view.screens.auth_screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.NavController
import com.example.zeko.data.model.UserEntity
import com.example.zeko.view.ScreenRoute
import com.example.zeko.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction2


@Composable
fun LoginScreen(viewModel: UserViewModel, navController: NavController) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

//    val user by viewModel.userLiveData.observeAsState()
//
//    user.let {
//        if(it != null){
//            Log.d("LiveData",it.toString())
//            navController.navigate(ScreenRoute.PostListScreen.route){
//                popUpTo(ScreenRoute.LoginScreen.route) { inclusive = true }
//            }
//
//        }
//
//    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .background(Color.Black), verticalArrangement = Arrangement.Center
    ) {

        val modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 15.dp, end = 15.dp)

        Text(
            text = "Login to Zeko",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        TextField(value = email,
            onValueChange = { email = it },
            modifier = modifier,
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.LightGray,
                textColor = Color.White,
                backgroundColor = Color.Black,
                focusedIndicatorColor = Color.DarkGray

            ),
            placeholder = {
                Text(
                    text = "Email..."
                )
            },
            label = {
                Text(text = "Email", color = Color.DarkGray)
            }
        )
        TextField(value = password,
            onValueChange = { password = it },
            modifier = modifier.padding(vertical = 35.dp),
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color.LightGray,
                textColor = Color.White,
                backgroundColor = Color.Black,
                focusedIndicatorColor = Color.DarkGray
            ),
            placeholder = {
                Text(
                    text = "password..."
                )
            },
            label = {
                Text(text = "Password", color = Color.DarkGray)
            }
        )
        Button(onClick = {


            coroutineScope.launch {
                val user = viewModel.getUser(email, password)
                if (user != null) {
                    navController.navigate(ScreenRoute.PostListScreen.route) {
                        popUpTo(ScreenRoute.LoginScreen.route) { inclusive = true }
                    }
                }
            }


        }) {
            Text(text = "Login")
        }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun AuthScreenPrev(){
//
//    LoginScreen(authViewModel::getUser)
//
//
//}
