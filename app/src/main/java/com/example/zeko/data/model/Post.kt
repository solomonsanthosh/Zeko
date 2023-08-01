package com.example.zeko.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "posts")
data class Post(


    @PrimaryKey val id: Int,
    val user: String,
    val title: String,
    val content: String,
    val created_at: Long


)