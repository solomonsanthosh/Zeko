package com.example.zeko.di;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.work.Configuration;
import com.example.zeko.utils.notification.NotificationService;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/example/zeko/di/ZekoApplication;", "Landroid/app/Application;", "Landroidx/work/Configuration$Provider;", "()V", "workerFactory", "Landroidx/hilt/work/HiltWorkerFactory;", "getWorkerFactory", "()Landroidx/hilt/work/HiltWorkerFactory;", "setWorkerFactory", "(Landroidx/hilt/work/HiltWorkerFactory;)V", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "onCreate", "", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class ZekoApplication extends android.app.Application implements androidx.work.Configuration.Provider {
    @javax.inject.Inject
    public androidx.hilt.work.HiltWorkerFactory workerFactory;
    
    public ZekoApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.hilt.work.HiltWorkerFactory getWorkerFactory() {
        return null;
    }
    
    public final void setWorkerFactory(@org.jetbrains.annotations.NotNull
    androidx.hilt.work.HiltWorkerFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}