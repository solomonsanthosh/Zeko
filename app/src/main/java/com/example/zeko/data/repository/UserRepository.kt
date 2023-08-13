package com.example.zeko.data.repository

import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.model.UserEntity
import retrofit2.Response

interface UserRepository {

     suspend fun getUser(email:String): UserEntity?
     suspend fun makeConnection(body: Map<String,String>): ResponseEntity

}