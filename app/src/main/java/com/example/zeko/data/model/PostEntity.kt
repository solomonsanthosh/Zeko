package com.example.zeko.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class PostEntity (

    @SerializedName("_id")
    val id: String,
    val user: @RawValue UserEntity,
    val title: String,
    val content: String,

    val created_at: Long,

    var comments: @RawValue List<CommentEntity>
) : Parcelable