package com.example.zeko.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.zeko.data.model.CommentEntity;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.data.model.PostLocalEntity;
import com.example.zeko.data.model.UserEntity;
import com.example.zeko.data.usecase.getMyCommentsUseCase;
import com.example.zeko.data.usecase.getMyPostsUseCase;
import com.example.zeko.data.usecase.getPostFromFollowingUseCase;
import com.example.zeko.data.usecase.getPostsUseCase;
import com.example.zeko.data.usecase.saveCommentUseCase;
import com.example.zeko.data.usecase.savePostUseCase;
import com.example.zeko.data.usecase.scedulePostUseCase;
import com.example.zeko.utils.notification.NotificationService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u0010&\u001a\u00020.J\u000e\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0016\u00103\u001a\u00020.2\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u001aJ\u000e\u00106\u001a\u00020.2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020.2\u0006\u00107\u001a\u000208R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180%0$8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n **\u0004\u0018\u00010)0)\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006:"}, d2 = {"Lcom/example/zeko/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "savePostUseCase", "Lcom/example/zeko/data/usecase/savePostUseCase;", "getPostsUseCase", "Lcom/example/zeko/data/usecase/getPostsUseCase;", "scedulePostUseCase", "Lcom/example/zeko/data/usecase/scedulePostUseCase;", "saveCommentUseCase", "Lcom/example/zeko/data/usecase/saveCommentUseCase;", "getPostFromFollowingUseCase", "Lcom/example/zeko/data/usecase/getPostFromFollowingUseCase;", "getMyPostsUseCase", "Lcom/example/zeko/data/usecase/getMyPostsUseCase;", "getMyCommentsUseCase", "Lcom/example/zeko/data/usecase/getMyCommentsUseCase;", "notificationService", "Lcom/example/zeko/utils/notification/NotificationService;", "context", "Landroid/app/Application;", "(Lcom/example/zeko/data/usecase/savePostUseCase;Lcom/example/zeko/data/usecase/getPostsUseCase;Lcom/example/zeko/data/usecase/scedulePostUseCase;Lcom/example/zeko/data/usecase/saveCommentUseCase;Lcom/example/zeko/data/usecase/getPostFromFollowingUseCase;Lcom/example/zeko/data/usecase/getMyPostsUseCase;Lcom/example/zeko/data/usecase/getMyCommentsUseCase;Lcom/example/zeko/utils/notification/NotificationService;Landroid/app/Application;)V", "_posts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/zeko/data/model/PostEntity;", "comments", "Lcom/example/zeko/data/model/CommentEntity;", "getComments", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setComments", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getContext", "()Landroid/app/Application;", "getNotificationService", "()Lcom/example/zeko/utils/notification/NotificationService;", "posts", "Lkotlinx/coroutines/flow/StateFlow;", "", "getPosts", "()Lkotlinx/coroutines/flow/StateFlow;", "usersharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getUsersharedPref", "()Landroid/content/SharedPreferences;", "getMyComments", "", "id", "", "getMyPosts", "getPostsFromFollowing", "saveComment", "postId", "commentEntity", "savePost", "post", "Lcom/example/zeko/data/model/PostLocalEntity;", "scedulePost", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.zeko.data.usecase.savePostUseCase savePostUseCase = null;
    private final com.example.zeko.data.usecase.getPostsUseCase getPostsUseCase = null;
    private final com.example.zeko.data.usecase.scedulePostUseCase scedulePostUseCase = null;
    private final com.example.zeko.data.usecase.saveCommentUseCase saveCommentUseCase = null;
    private final com.example.zeko.data.usecase.getPostFromFollowingUseCase getPostFromFollowingUseCase = null;
    private final com.example.zeko.data.usecase.getMyPostsUseCase getMyPostsUseCase = null;
    private final com.example.zeko.data.usecase.getMyCommentsUseCase getMyCommentsUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.zeko.utils.notification.NotificationService notificationService = null;
    @org.jetbrains.annotations.NotNull
    private final android.app.Application context = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.zeko.data.model.PostEntity>> _posts = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.zeko.data.model.CommentEntity>> comments;
    private final android.content.SharedPreferences usersharedPref = null;
    
    @javax.inject.Inject
    public PostViewModel(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.savePostUseCase savePostUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.getPostsUseCase getPostsUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.scedulePostUseCase scedulePostUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.saveCommentUseCase saveCommentUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.getPostFromFollowingUseCase getPostFromFollowingUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.getMyPostsUseCase getMyPostsUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.usecase.getMyCommentsUseCase getMyCommentsUseCase, @org.jetbrains.annotations.NotNull
    com.example.zeko.utils.notification.NotificationService notificationService, @org.jetbrains.annotations.NotNull
    android.app.Application context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.zeko.utils.notification.NotificationService getNotificationService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.Application getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.zeko.data.model.PostEntity>> getPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.zeko.data.model.CommentEntity>> getComments() {
        return null;
    }
    
    public final void setComments(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.zeko.data.model.CommentEntity>> p0) {
    }
    
    public final android.content.SharedPreferences getUsersharedPref() {
        return null;
    }
    
    public final void getPosts() {
    }
    
    public final void getPostsFromFollowing(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void getMyPosts(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
    
    public final void savePost(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post) {
    }
    
    public final void saveComment(@org.jetbrains.annotations.NotNull
    java.lang.String postId, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.CommentEntity commentEntity) {
    }
    
    public final void scedulePost(@org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.PostLocalEntity post) {
    }
    
    public final void getMyComments(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
    }
}