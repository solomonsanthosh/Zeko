package com.example.zeko.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.zeko.data.model.PostLocalEntity;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/zeko/data/db/PostDao;", "", "getPost", "Lcom/example/zeko/data/model/PostLocalEntity;", "beforetime", "", "time", "getPostsOffline", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePost", "", "post", "(Lcom/example/zeko/data/model/PostLocalEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PostDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object savePost(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * from posts WHERE created_at >= :beforetime AND created_at <= :time")
    public abstract com.example.zeko.data.model.PostLocalEntity getPost(long beforetime, long time);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * from posts WHERE type = \'offline\'")
    public abstract java.lang.Object getPostsOffline(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.zeko.data.model.PostLocalEntity>> continuation);
}