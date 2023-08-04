package com.example.zeko.data.datasource;

import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u0006\u0010\t\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/zeko/data/datasource/PostRemoteDataSource;", "", "getPostsFromApi", "Lretrofit2/Response;", "", "Lcom/example/zeko/data/model/PostEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCommentToApi", "Lcom/example/zeko/data/model/CommentEntity;", "commentEntity", "(Lcom/example/zeko/data/model/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePostToApi", "Lcom/example/zeko/data/model/PostLocalEntity;", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PostRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object savePostToApi(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.zeko.data.model.PostLocalEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveCommentToApi(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.CommentEntity commentEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.zeko.data.model.CommentEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPostsFromApi(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
}