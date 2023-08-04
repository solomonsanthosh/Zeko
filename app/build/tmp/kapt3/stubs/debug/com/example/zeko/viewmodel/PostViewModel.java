package com.example.zeko.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import com.example.zeko.data.model.User;
import com.example.zeko.data.usecase.getPostsUseCase;
import com.example.zeko.data.usecase.saveCommentUseCase;
import com.example.zeko.data.usecase.savePostUseCase;
import com.example.zeko.data.usecase.scedulePostUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u001fJ\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00150\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/example/zeko/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "savePostUseCase", "Lcom/example/zeko/data/usecase/savePostUseCase;", "getPostsUseCase", "Lcom/example/zeko/data/usecase/getPostsUseCase;", "scedulePostUseCase", "Lcom/example/zeko/data/usecase/scedulePostUseCase;", "saveCommentUseCase", "Lcom/example/zeko/data/usecase/saveCommentUseCase;", "context", "Landroid/app/Application;", "(Lcom/example/zeko/data/usecase/savePostUseCase;Lcom/example/zeko/data/usecase/getPostsUseCase;Lcom/example/zeko/data/usecase/scedulePostUseCase;Lcom/example/zeko/data/usecase/saveCommentUseCase;Landroid/app/Application;)V", "_posts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/zeko/data/model/PostEntity;", "getContext", "()Landroid/app/Application;", "posts", "Lkotlinx/coroutines/flow/StateFlow;", "", "getPosts", "()Lkotlinx/coroutines/flow/StateFlow;", "usersharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getUsersharedPref", "()Landroid/content/SharedPreferences;", "", "getUser", "Lcom/example/zeko/data/model/User;", "saveComment", "postId", "", "commentEntity", "Lcom/example/zeko/data/model/CommentEntity;", "savePost", "post", "Lcom/example/zeko/data/model/PostLocalEntity;", "saveUser", "user", "scedulePost", "updateComment", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.zeko.data.usecase.savePostUseCase savePostUseCase = null;
    private final com.example.zeko.data.usecase.getPostsUseCase getPostsUseCase = null;
    private final com.example.zeko.data.usecase.scedulePostUseCase scedulePostUseCase = null;
    private final com.example.zeko.data.usecase.saveCommentUseCase saveCommentUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application context = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.zeko.data.model.PostEntity>> _posts = null;
    private final android.content.SharedPreferences usersharedPref = null;
    
    @javax.inject.Inject()
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.savePostUseCase savePostUseCase, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.getPostsUseCase getPostsUseCase, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.scedulePostUseCase scedulePostUseCase, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.usecase.saveCommentUseCase saveCommentUseCase, @org.jetbrains.annotations.NotNull()
    android.app.Application context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.zeko.data.model.PostEntity>> getPosts() {
        return null;
    }
    
    public final android.content.SharedPreferences getUsersharedPref() {
        return null;
    }
    
    public final void getPosts() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.zeko.data.model.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String saveUser(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.User user) {
        return null;
    }
    
    public final void savePost(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post) {
    }
    
    public final void saveComment(@org.jetbrains.annotations.NotNull()
    java.lang.String postId, @org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.CommentEntity commentEntity) {
    }
    
    public final void scedulePost(@org.jetbrains.annotations.NotNull()
    com.example.zeko.data.model.PostLocalEntity post) {
    }
    
    public final void updateComment(@org.jetbrains.annotations.NotNull()
    java.lang.String postId) {
    }
}