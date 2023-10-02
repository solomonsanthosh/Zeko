package com.example.zeko.data.repository.implementation

import android.util.Log
import com.example.zeko.data.api.UserService
import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.repository.UserRepository

class UserRepositoryImpl(private val authService: UserService):UserRepository {
    override suspend fun getUser(email: String): UserEntity? {

        var user: UserEntity? = null
        try {
            val response = authService.getUser(email)
            val body = response.body()
            Log.d("BodyMsg",body.toString())

            user  = if (body != null) {

                body
            } else {
                null
            }

        } catch (exception: java.lang.Exception) {
            Log.d("ERR",exception.localizedMessage.toString())
            return null
        }
        return user

    }

    override suspend fun getFollowings(id: String, type: String): List<UserEntity> {
        var userList: List<UserEntity> = emptyList()
        try {
            val response = authService.getFollowings(id,type)
            val body = response.body()
            Log.d("BodyMsg",body.toString())

            userList  = if (body != null) {

                body
            } else {
                return userList
            }

        } catch (exception: java.lang.Exception) {
            exception.localizedMessage?.let { Log.d("ERR", it.toString()) }
            return userList
        }
        return userList
    }

    override suspend fun makeConnection(body: Map<String, String>): ResponseEntity {
        val response = authService.makeConnection(body)
        return response.body() as ResponseEntity

    }

    override suspend fun getUserByPhone(phone: String): ResponseEntity {

        val response = authService.getUserByPhone(phone)
        return response.body() as ResponseEntity

    }
}