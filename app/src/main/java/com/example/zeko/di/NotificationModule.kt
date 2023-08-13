package com.example.zeko.di

import android.app.Application
import com.example.zeko.data.api.PostService
import com.example.zeko.utils.notification.NotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NotificationModule {


    @Singleton
    @Provides
    fun provideNotificationService(context:Application): NotificationService {
        return NotificationService(context)
    }



}