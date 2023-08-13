package com.example.zeko.di;

import android.app.Application;
import androidx.room.Room;
import com.example.zeko.data.db.PostDao;
import com.example.zeko.data.db.ZekoDB;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/example/zeko/di/DBModule;", "", "()V", "providePostDao", "Lcom/example/zeko/data/db/PostDao;", "zekoDB", "Lcom/example/zeko/data/db/ZekoDB;", "provideRoomDB", "context", "Landroid/app/Application;", "app_debug"})
@dagger.Module
public final class DBModule {
    
    public DBModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.zeko.data.db.ZekoDB provideRoomDB(@org.jetbrains.annotations.NotNull
    android.app.Application context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.zeko.data.db.PostDao providePostDao(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.db.ZekoDB zekoDB) {
        return null;
    }
}