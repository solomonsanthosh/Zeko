package com.example.zeko.utils.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.zeko.data.repository.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkCheckReceiver(private val networkChecker: NetworkChecker) : BroadcastReceiver() {
//    ,private val postRepository: PostRepository
    override fun onReceive(context: Context, intent: Intent) {

//        context.let {
//            val connectivityManager = it.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val networkInfo = connectivityManager.activeNetworkInfo
//            if(networkInfo == null || !networkInfo.isConnected){
//                Toast.makeText(context,"You are now Offline",Toast.LENGTH_LONG).show()
//            } else {
//                if(networkInfo.isConnected){
//                    Toast.makeText(context,"Back Online",Toast.LENGTH_LONG).show()
//                }
//            }
//
//        }
        val res = networkChecker.execute()
        if(res){
//            CoroutineScope(Dispatchers.IO).launch {
//               val posts =   postRepository.getPostsOffline()
//                if(posts!=null){
//                    posts.forEach {
//                        postRepository.savePosts(it).also {
//                            if (it != null) {
//                                postRepository.deletePostFromOffline(it.id)
//                            }
//                        }
//                    }
//                                    }
//            }


            Toast.makeText(context,"Back Online",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context,"You are now Offline",Toast.LENGTH_LONG).show()
        }

    }
}