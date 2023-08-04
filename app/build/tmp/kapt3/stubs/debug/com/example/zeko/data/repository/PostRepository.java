package com.example.zeko.data.repository;

import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/zeko/data/repository/PostRepository;", "", "getPosts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/zeko/data/model/PostEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScheduledPost", "Lcom/example/zeko/data/model/PostLocalEntity;", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveComment", "Lcom/example/zeko/data/model/CommentEntity;", "commentEntity", "(Lcom/example/zeko/data/model/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePosts", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scedulePost", "", "app_debug"})
public abstract interface PostRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPosts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object savePosts(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveComment(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.CommentEntity commentEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.CommentEntity> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object scedulePost(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getScheduledPost(long time, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation);
}