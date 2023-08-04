package com.example.zeko.di;

import com.example.zeko.data.repository.PostRepository;
import com.example.zeko.data.usecase.*;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/example/zeko/di/UseCaseModule;", "", "()V", "provideGetPostUseCase", "Lcom/example/zeko/data/usecase/getPostsUseCase;", "postRepository", "Lcom/example/zeko/data/repository/PostRepository;", "provideGetScheduledPostUseCase", "Lcom/example/zeko/data/usecase/getScheduledPostUseCase;", "provideSaveCommentUseCase", "Lcom/example/zeko/data/usecase/saveCommentUseCase;", "provideSavePostUseCase", "Lcom/example/zeko/data/usecase/savePostUseCase;", "provideSchedulePostUseCase", "Lcom/example/zeko/data/usecase/scedulePostUseCase;", "app_debug"})
@dagger.Module()
public final class UseCaseModule {
    
    public UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.zeko.data.usecase.getPostsUseCase provideGetPostUseCase(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.zeko.data.usecase.savePostUseCase provideSavePostUseCase(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.zeko.data.usecase.saveCommentUseCase provideSaveCommentUseCase(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.zeko.data.usecase.scedulePostUseCase provideSchedulePostUseCase(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.example.zeko.data.usecase.getScheduledPostUseCase provideGetScheduledPostUseCase(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.repository.PostRepository postRepository) {
        return null;
    }
}