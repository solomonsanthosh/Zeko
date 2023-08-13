package com.example.zeko.di;

import com.example.zeko.data.repository.PostRepository;
import com.example.zeko.data.repository.UserRepository;
import com.example.zeko.data.usecase.*;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u001b"}, d2 = {"Lcom/example/zeko/di/UseCaseModule;", "", "()V", "provideGetMyCommentsUseCase", "Lcom/example/zeko/data/usecase/getMyCommentsUseCase;", "postRepository", "Lcom/example/zeko/data/repository/PostRepository;", "provideGetMyPostUseCase", "Lcom/example/zeko/data/usecase/getMyPostsUseCase;", "provideGetPostFromFollowingUseCase", "Lcom/example/zeko/data/usecase/getPostFromFollowingUseCase;", "provideGetPostUseCase", "Lcom/example/zeko/data/usecase/getPostsUseCase;", "provideGetScheduledPostUseCase", "Lcom/example/zeko/data/usecase/getScheduledPostUseCase;", "provideGetUserUseCase", "Lcom/example/zeko/data/usecase/getUserUseCase;", "userRepository", "Lcom/example/zeko/data/repository/UserRepository;", "provideMakeConnectionUseCase", "Lcom/example/zeko/data/usecase/makeConnectionUseCase;", "provideSaveCommentUseCase", "Lcom/example/zeko/data/usecase/saveCommentUseCase;", "provideSavePostUseCase", "Lcom/example/zeko/data/usecase/savePostUseCase;", "provideSchedulePostUseCase", "Lcom/example/zeko/data/usecase/scedulePostUseCase;", "app_debug"})
@dagger.Module
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getPostsUseCase provideGetPostUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getPostFromFollowingUseCase provideGetPostFromFollowingUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getMyPostsUseCase provideGetMyPostUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getMyCommentsUseCase provideGetMyCommentsUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.savePostUseCase provideSavePostUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.saveCommentUseCase provideSaveCommentUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.scedulePostUseCase provideSchedulePostUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getScheduledPostUseCase provideGetScheduledPostUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.getUserUseCase provideGetUserUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.UserRepository userRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.usecase.makeConnectionUseCase provideMakeConnectionUseCase(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.repository.UserRepository userRepository) {
        return null;
    }
}