package com.example.zeko.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zeko.data.model.PostLocalEntity


@Database(entities = [PostLocalEntity::class], version = 1,exportSchema = true)
abstract class ZekoDB: RoomDatabase() {

    abstract fun postDao():PostDao
}