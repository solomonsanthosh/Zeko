package com.example.zeko.data.repository.implementation;

import android.app.Application;
import android.util.Log;
import androidx.work.*;
import com.example.zeko.data.datasource.PostLocalDataSource;
import com.example.zeko.data.datasource.PostRemoteDataSource;
import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import com.example.zeko.data.repository.PostRepository;
import com.example.zeko.data.worker.ScheduledPostWorker;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/zeko/data/repository/implementation/PostRepositoryImpl;", "Lcom/example/zeko/data/repository/PostRepository;", "postRemoteDataSource", "Lcom/example/zeko/data/datasource/PostRemoteDataSource;", "postLocalDataSource", "Lcom/example/zeko/data/datasource/PostLocalDataSource;", "context", "Landroid/app/Application;", "(Lcom/example/zeko/data/datasource/PostRemoteDataSource;Lcom/example/zeko/data/datasource/PostLocalDataSource;Landroid/app/Application;)V", "getPosts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/zeko/data/model/PostEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScheduledPost", "Lcom/example/zeko/data/model/PostLocalEntity;", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveComment", "Lcom/example/zeko/data/model/CommentEntity;", "commentEntity", "(Lcom/example/zeko/data/model/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePosts", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scedulePost", "", "app_debug"})
public final class PostRepositoryImpl implements com.example.zeko.data.repository.PostRepository {
    private final com.example.zeko.data.datasource.PostRemoteDataSource postRemoteDataSource = null;
    private final com.example.zeko.data.datasource.PostLocalDataSource postLocalDataSource = null;
    private final android.app.Application context = null;
    
    public PostRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.datasource.PostRemoteDataSource postRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.datasource.PostLocalDataSource postLocalDataSource, @org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPosts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.PostEntity>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object savePosts(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveComment(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.CommentEntity commentEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.CommentEntity> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object scedulePost(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getScheduledPost(long time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation) {
        return null;
    }
}