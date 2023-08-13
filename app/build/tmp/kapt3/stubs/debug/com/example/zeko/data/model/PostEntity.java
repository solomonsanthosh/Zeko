package com.example.zeko.data.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlinx.parcelize.Parcelize;
import kotlinx.parcelize.RawValue;

@kotlinx.parcelize.Parcelize
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000b\u0010\u0004\u001a\u00070\u0005\u00a2\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000e\u0010\u001c\u001a\u00070\u0005\u00a2\u0006\u0002\b\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J\u0014\u0010 \u001a\r\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u0006H\u00c6\u0003JU\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\r\b\u0002\u0010\u0004\u001a\u00070\u0005\u00a2\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u0006H\u00c6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u00d6\u0003J\t\u0010(\u001a\u00020#H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#H\u00d6\u0001R%\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u0004\u001a\u00070\u0005\u00a2\u0006\u0002\b\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006/"}, d2 = {"Lcom/example/zeko/data/model/PostEntity;", "Landroid/os/Parcelable;", "id", "", "user", "Lcom/example/zeko/data/model/UserEntity;", "Lkotlinx/parcelize/RawValue;", "title", "content", "created_at", "", "comments", "", "Lcom/example/zeko/data/model/CommentEntity;", "(Ljava/lang/String;Lcom/example/zeko/data/model/UserEntity;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getCreated_at", "()J", "getId", "getTitle", "getUser", "()Lcom/example/zeko/data/model/UserEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class PostEntity implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "_id")
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.zeko.data.model.UserEntity user = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String content = null;
    private final long created_at = 0L;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.zeko.data.model.CommentEntity> comments;
    public static final android.os.Parcelable.Creator<com.example.zeko.data.model.PostEntity> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.zeko.data.model.PostEntity copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.UserEntity user, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content, long created_at, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.zeko.data.model.CommentEntity> comments) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public PostEntity(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    com.example.zeko.data.model.UserEntity user, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String content, long created_at, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.zeko.data.model.CommentEntity> comments) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.zeko.data.model.UserEntity component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.zeko.data.model.UserEntity getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getCreated_at() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.zeko.data.model.CommentEntity> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.zeko.data.model.CommentEntity> getComments() {
        return null;
    }
    
    public final void setComments(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.zeko.data.model.CommentEntity> p0) {
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.example.zeko.data.model.PostEntity> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.example.zeko.data.model.PostEntity createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public final com.example.zeko.data.model.PostEntity[] newArray(int size) {
            return null;
        }
    }
}