package com.example.zeko.data.usecase

import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.repository.UserRepository

class getUserByPhoneUseCase(val userRepository: UserRepository) {
    suspend fun execute(phone:String) = userRepository.getUserByPhone(phone)

}