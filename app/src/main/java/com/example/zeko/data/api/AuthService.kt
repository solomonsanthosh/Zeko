package com.example.zeko.data.api

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.model.UserEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface AuthService {

    @GET("user/{email}")
    suspend fun getUser(@Path("email") email: String): Response<UserEntity>

    @PUT("connection")
    suspend fun makeConnection(@Body body: Map<String,String>): Response<ResponseEntity>

}