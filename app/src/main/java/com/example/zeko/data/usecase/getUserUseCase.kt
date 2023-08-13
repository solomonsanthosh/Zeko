package com.example.zeko.data.usecase

import com.example.zeko.data.model.PostLocalEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.repository.UserRepository

class getUserUseCase(private val userRepository: UserRepository) {

     suspend fun execute(email:String): UserEntity? = userRepository.getUser(email)



}