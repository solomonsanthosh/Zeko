package com.example.zeko.view



    sealed class ScreenRoute(val route:String){
        object PostAddScreen: ScreenRoute("post_add_screen")
        object PostListScreen: ScreenRoute("post_list_screen")

        object PostSingleScreen: ScreenRoute("post_single_screen")
        object CommentAddScreen: ScreenRoute("comment_add_screen")






    }