package com.example.zeko.data.model

import com.google.gson.annotations.SerializedName


data class UserEntity(
    @SerializedName("_id")
    val id: String,
    val name: String,
    val email: String,
    val following: List<String>,
    val followers: List<String>

)
