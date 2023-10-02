package com.example.zeko.di

import android.app.Application
import com.example.zeko.data.api.UserService
import com.example.zeko.data.api.PostService
import com.example.zeko.data.datasource.Implementation.PostLocalDataSourceImpl
import com.example.zeko.data.datasource.Implementation.PostRemoteDataSourceImpl
import com.example.zeko.data.datasource.PostLocalDataSource
import com.example.zeko.data.datasource.PostRemoteDataSource
import com.example.zeko.data.db.PostDao
import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.UserRepository
import com.example.zeko.data.repository.implementation.PostRepositoryImpl
import com.example.zeko.data.repository.implementation.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class repoositoryModule {



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


    @Singleton
    @Provides
    fun provideUserRepository(authService: UserService): UserRepository {
        return UserRepositoryImpl(authService)
    }


}