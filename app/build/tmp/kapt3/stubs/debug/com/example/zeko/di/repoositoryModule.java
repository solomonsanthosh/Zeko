package com.example.zeko.di;

import android.app.Application;
import com.example.zeko.data.api.UserService;
import com.example.zeko.data.api.PostService;
import com.example.zeko.data.datasource.Implementation.PostLocalDataSourceImpl;
import com.example.zeko.data.datasource.Implementation.PostRemoteDataSourceImpl;
import com.example.zeko.data.datasource.PostLocalDataSource;
import com.example.zeko.data.datasource.PostRemoteDataSource;
import com.example.zeko.data.db.PostDao;
import com.example.zeko.data.repository.PostRepository;
import com.example.zeko.data.repository.UserRepository;
import com.example.zeko.data.repository.implementation.PostRepositoryImpl;
import com.example.zeko.data.repository.implementation.UserRepositoryImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/zeko/di/repoositoryModule;", "", "()V", "providePostLocalDataSource", "Lcom/example/zeko/data/datasource/PostLocalDataSource;", "postDao", "Lcom/example/zeko/data/db/PostDao;", "providePostRemoteDataSource", "Lcom/example/zeko/data/datasource/PostRemoteDataSource;", "postService", "Lcom/example/zeko/data/api/PostService;", "providePostRepository", "Lcom/example/zeko/data/repository/PostRepository;", "remoteDataSource", "localDataSource", "context", "Landroid/app/Application;", "provideUserRepository", "Lcom/example/zeko/data/repository/UserRepository;", "authService", "Lcom/example/zeko/data/api/UserService;", "app_debug"})
@dagger.Module
public final class repoositoryModule {
    
    public repoositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.datasource.PostLocalDataSource providePostLocalDataSource(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.db.PostDao postDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.datasource.PostRemoteDataSource providePostRemoteDataSource(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.api.PostService postService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.repository.PostRepository providePostRepository(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.datasource.PostRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.datasource.PostLocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    android.app.Application context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.zeko.data.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.api.UserService authService) {
        return null;
    }
}