package com.example.zeko.data.datasource.Implementation;

import com.example.zeko.data.datasource.PostLocalDataSource;
import com.example.zeko.data.db.PostDao;
import com.example.zeko.data.model.PostLocalEntity;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/zeko/data/datasource/Implementation/PostLocalDataSourceImpl;", "Lcom/example/zeko/data/datasource/PostLocalDataSource;", "postDao", "Lcom/example/zeko/data/db/PostDao;", "(Lcom/example/zeko/data/db/PostDao;)V", "getPostFromLocal", "Lcom/example/zeko/data/model/PostLocalEntity;", "timebefore", "", "time", "getPostsOffline", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePostToLocal", "", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PostLocalDataSourceImpl implements com.example.zeko.data.datasource.PostLocalDataSource {
    private final com.example.zeko.data.db.PostDao postDao = null;
    
    public PostLocalDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.db.PostDao postDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object savePostToLocal(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.zeko.data.model.PostLocalEntity getPostFromLocal(long timebefore, long time) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getPostsOffline(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.zeko.data.model.PostLocalEntity>> continuation) {
        return null;
    }
}