package com.example.zeko.data.datasource;

import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import com.example.zeko.data.model.UserEntity;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ!\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/zeko/data/datasource/PostRemoteDataSource;", "", "getMyComments", "Lretrofit2/Response;", "", "Lcom/example/zeko/data/model/CommentEntity;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyPosts", "Lcom/example/zeko/data/model/PostEntity;", "getPostsFromApi", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsFromFollowingApi", "saveCommentToApi", "commentEntity", "(Lcom/example/zeko/data/model/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePostToApi", "Lcom/example/zeko/data/model/PostLocalEntity;", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PostRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object savePostToApi(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.zeko.data.model.PostLocalEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object saveCommentToApi(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.CommentEntity commentEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.zeko.data.model.CommentEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPostsFromApi(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPostsFromFollowingApi(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMyPosts(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.zeko.data.model.PostEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMyComments(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.zeko.data.model.CommentEntity>>> continuation);
}