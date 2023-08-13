package com.example.zeko.di

import com.example.zeko.data.repository.PostRepository
import com.example.zeko.data.repository.UserRepository
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
    fun provideGetPostFromFollowingUseCase(postRepository: PostRepository): getPostFromFollowingUseCase {
        return getPostFromFollowingUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideGetMyPostUseCase(postRepository: PostRepository): getMyPostsUseCase {
        return getMyPostsUseCase(postRepository)

    }
    @Singleton
    @Provides
    fun provideGetMyCommentsUseCase(postRepository: PostRepository): getMyCommentsUseCase  {
        return getMyCommentsUseCase(postRepository)

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

    @Singleton
    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): getUserUseCase {
        return getUserUseCase(userRepository)

    }
    @Singleton
    @Provides
    fun provideMakeConnectionUseCase(userRepository: UserRepository): makeConnectionUseCase {
        return makeConnectionUseCase(userRepository)

    }


}