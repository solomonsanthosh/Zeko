package com.example.zeko.data.usecase

import com.example.zeko.data.model.CommentEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class getFollowingUseCase(private val userRepository: UserRepository ) {

    suspend fun execute(id:String,type:String): List<UserEntity> = userRepository.getFollowings(id,type)
}