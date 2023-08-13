package com.example.zeko.data.usecase

import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.repository.UserRepository

class makeConnectionUseCase(private val userRepository: UserRepository) {

    suspend fun execute(body:Map<String,String>): ResponseEntity = userRepository.makeConnection(body)



}