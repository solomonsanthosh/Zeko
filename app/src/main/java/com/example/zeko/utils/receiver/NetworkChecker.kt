package com.example.zeko.utils.receiver

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkChecker(private val context: Context) {

    fun execute():Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
         return if(networkInfo == null || !networkInfo.isConnected){
            false
        } else networkInfo.isConnected


    }
}