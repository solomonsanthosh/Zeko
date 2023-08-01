package com.example.zeko.view.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.example.zeko.data.model.Post
import com.example.zeko.viewmodel.PostViewModel


@Composable
fun PostCard(item: Post) {

    Card(
//        border = BorderStroke(1.dp,Color.LightGray),
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
        , elevation = 1.dp, shape = RoundedCornerShape(5.dp), backgroundColor = Color.Black
    ) {



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = "@${item.user}",
                color = Color.LightGray,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = item.title,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = item.title,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 5.dp)
            )


        }
    }
    Divider(color = Color.LightGray, thickness = 1.dp)

}