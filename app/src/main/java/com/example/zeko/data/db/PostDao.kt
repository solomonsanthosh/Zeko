package com.example.zeko.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zeko.data.model.Post


@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePost(post: Post)



    @Query("SELECT * from posts WHERE created_at = :time")
    fun getPost(time:Long) : Post



}