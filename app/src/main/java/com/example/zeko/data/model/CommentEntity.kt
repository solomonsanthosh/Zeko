package com.example.zeko.data.model

data class CommentEntity(
    val id: String,
    val user: UserEntity,
    val content: String,

    )