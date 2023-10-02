package com.example.zeko.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zeko.R
import com.example.zeko.data.model.PostEntity


@Composable
fun PostSingleScreen(data: PostEntity?) {

    LazyColumn(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()){
        item {

            Column(){

                if (data != null) {
                    Text(text = "@${data.user.name}",

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

            }



        }



        item {
            Text(text = "Comments",modifier = Modifier.padding(start = 10.dp, top = 10.dp), fontWeight = FontWeight.Medium)
            Divider(color = Color.DarkGray, thickness = 2.dp, modifier = Modifier.padding(top = 8.dp))

        }
        if (data != null) {
            items(data.comments){
                Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 5.dp)){


                    Text(text = "@${it.user.name}",color = colorResource(id = R.color.teal_700),fontSize = 15.sp, modifier = Modifier.padding(bottom = 2.dp))
                    Text(text = it.content)
                    Divider(color = Color.DarkGray, thickness = 2.dp, modifier = Modifier.padding(top = 8.dp))

                }

            }
        }
    }

}