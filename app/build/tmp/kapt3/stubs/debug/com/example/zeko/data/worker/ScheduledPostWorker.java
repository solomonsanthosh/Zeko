package com.example.zeko.data.worker;

import android.content.Context;
import android.util.Log;
import androidx.hilt.work.HiltWorker;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.example.zeko.data.usecase.getScheduledPostUseCase;
import com.example.zeko.data.usecase.savePostUseCase;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/zeko/data/worker/ScheduledPostWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "getScheduledPostUseCase", "Lcom/example/zeko/data/usecase/getScheduledPostUseCase;", "savePostUseCase", "Lcom/example/zeko/data/usecase/savePostUseCase;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/example/zeko/data/usecase/getScheduledPostUseCase;Lcom/example/zeko/data/usecase/savePostUseCase;)V", "getGetScheduledPostUseCase", "()Lcom/example/zeko/data/usecase/getScheduledPostUseCase;", "getSavePostUseCase", "()Lcom/example/zeko/data/usecase/savePostUseCase;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ScheduledPostWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.example.zeko.data.usecase.getScheduledPostUseCase getScheduledPostUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.zeko.data.usecase.savePostUseCase savePostUseCase = null;
    
    @dagger.assisted.AssistedInject()
    public ScheduledPostWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters workerParameters, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.getScheduledPostUseCase getScheduledPostUseCase, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.savePostUseCase savePostUseCase) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.zeko.data.usecase.getScheduledPostUseCase getGetScheduledPostUseCase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.zeko.data.usecase.savePostUseCase getSavePostUseCase() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
}