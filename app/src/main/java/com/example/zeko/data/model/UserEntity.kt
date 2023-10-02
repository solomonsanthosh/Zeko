package com.example.zeko.data.model

import com.google.gson.annotations.SerializedName


data class UserEntity(
    @SerializedName("_id")
    val id: String,
    val name: String,
    val email: String,
    val phone:Long,
    val following: List<String>,
    val followers: List<String>

)
