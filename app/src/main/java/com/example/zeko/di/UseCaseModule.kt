package com.example.zeko.di

import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Singleton
    @Provides
    fun provideGetPostUseCase(postRepository: PostRepository): getPostsUseCase {
        return getPostsUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideSavePostUseCase(postRepository: PostRepository): savePostUseCase {
        return savePostUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideSaveCommentUseCase(postRepository: PostRepository): saveCommentUseCase {
        return saveCommentUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideSchedulePostUseCase(postRepository: PostRepository): scedulePostUseCase {
        return scedulePostUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideGetScheduledPostUseCase(postRepository: PostRepository): getScheduledPostUseCase {
        return getScheduledPostUseCase(postRepository)

    }

}