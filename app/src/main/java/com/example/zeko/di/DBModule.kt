package com.example.zeko.di

import android.app.Application
import androidx.room.Room
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.db.ZekoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class DBModule {
    @Provides
    @Singleton
    fun provideRoomDB(context: Application): ZekoDB {
        return Room.databaseBuilder(
            context.applicationContext,
            ZekoDB::class.java,
            "zeko_db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun providePostDao(zekoDB: ZekoDB): PostDao {

        return zekoDB.postDao()
    }

}