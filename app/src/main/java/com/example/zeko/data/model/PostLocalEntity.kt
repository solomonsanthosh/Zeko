package com.example.zeko.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "posts")
data class PostLocalEntity(


    @PrimaryKey val id: Int,
    val user: String,
    val title: String,
    val content: String,
    val created_at: Long,



)