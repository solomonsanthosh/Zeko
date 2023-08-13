package com.example.zeko.view.screens



import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zeko.R
import com.example.zeko.data.model.PostEntity
import com.example.zeko.view.ScreenRoute
import com.example.zeko.viewmodel.PostViewModel
import com.example.zeko.viewmodel.UserViewModel


@Composable
fun PostCard(
    item: PostEntity,
    navController: NavController,
    viewModel: PostViewModel,
    authViewModel: UserViewModel
) {

    val coroutineScope  = rememberCoroutineScope()
    Card(
//        border = BorderStroke(1.dp,Color.LightGray),
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 7.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("post", item)
                navController.navigate(ScreenRoute.PostSingleScreen.route)
            }
        , elevation = 25.dp, shape = RoundedCornerShape(5.dp), backgroundColor = Color.Black
    ) {



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "(${item.user.name})",

                    color = Color.Yellow,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                    Text(modifier = Modifier
                        .padding(top = 5.dp)
                        .clickable {

                            var type = "push"
                            if (authViewModel.userLiveData.value?.id in item.user.followers) {
                                type = "pull"
                            }

                                authViewModel.makeConnection(item.user.id,viewModel::getPosts,type)

                        },text = if (authViewModel.userLiveData.value?.id in item.user.followers) {
                        "following"
                    } else {
                        "follow"
                    }, fontSize = 15.sp, color = Color.LightGray)

            }

            Text(
                text = item.title,
                color = Color.LightGray,
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = item.content,
                color = colorResource(id = R.color.content),
                modifier = Modifier.padding(top = 5.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp, bottom = 7.dp)) {
                Image(
                     painterResource(R.drawable.comment),
                    contentDescription = "comment",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(18.dp)
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.set("post", item)
                            navController.navigate(ScreenRoute.CommentAddScreen.route)
                        }
                )
                Text(text = "${item.comments.size} comments", modifier = Modifier.padding(horizontal = 5.dp),fontSize = 15.sp, color = Color.LightGray)
            }


        }
    }
    Divider(color = Color.DarkGray, thickness = 2.dp)

}