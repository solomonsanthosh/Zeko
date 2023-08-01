package com.example.zeko.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.zeko.BuildConfig
import com.example.zeko.data.api.PostService
import com.example.zeko.data.datasource.Implementation.PostLocalDataSourceImpl
import com.example.zeko.data.datasource.Implementation.PostRemoteDataSourceImpl
import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.datasource.PostRemoteDataSource
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.db.ZekoDB
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.implementation.PostRepositoryImpl
import com.example.zeko.data.usecase.getPostsUseCase
import com.example.zeko.data.usecase.savePostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {



    @Singleton
    @Provides
    fun providePostLocalDataSource(postDao: PostDao): PostLocalDataSource {
        return PostLocalDataSourceImpl(postDao)
    }

    @Singleton
    @Provides
    fun providePostRemoteDataSource(postService: PostService): PostRemoteDataSource {
        return PostRemoteDataSourceImpl(postService)

    }


    @Singleton
    @Provides
    fun providePostRepository(
        remoteDataSource: PostRemoteDataSource,
        localDataSource: PostLocalDataSource,
        context: Application
    ): PostRepository {
        return PostRepositoryImpl(remoteDataSource, localDataSource,context)

    }


}