package com.example.zeko.data.repository;

import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/zeko/data/repository/PostRepository;", "", "getMyComments", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/zeko/data/model/CommentEntity;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyPosts", "Lcom/example/zeko/data/model/PostEntity;", "getPosts", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsFromFollowing", "getPostsOffline", "Lcom/example/zeko/data/model/PostLocalEntity;", "getScheduledPost", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveComment", "commentEntity", "(Lcom/example/zeko/data/model/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePosts", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scedulePost", "", "app_debug"})
public abstract interface PostRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPosts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMyPosts(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMyComments(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.CommentEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPostsFromFollowing(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object savePosts(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object saveComment(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.CommentEntity commentEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.CommentEntity> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object scedulePost(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getScheduledPost(long time, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.zeko.data.model.PostLocalEntity> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPostsOffline(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.zeko.data.model.PostLocalEntity>> continuation);
}