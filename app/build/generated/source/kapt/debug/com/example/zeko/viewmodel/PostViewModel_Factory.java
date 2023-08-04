// Generated by Dagger (https://dagger.dev).
package com.example.zeko.viewmodel;

import android.app.Application;
import com.example.zeko.data.usecase.getPostsUseCase;
import com.example.zeko.data.usecase.saveCommentUseCase;
import com.example.zeko.data.usecase.savePostUseCase;
import com.example.zeko.data.usecase.scedulePostUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PostViewModel_Factory implements Factory<PostViewModel> {
  private final Provider<savePostUseCase> savePostUseCaseProvider;

  private final Provider<getPostsUseCase> getPostsUseCaseProvider;

  private final Provider<scedulePostUseCase> scedulePostUseCaseProvider;

  private final Provider<saveCommentUseCase> saveCommentUseCaseProvider;

  private final Provider<Application> contextProvider;

  public PostViewModel_Factory(Provider<savePostUseCase> savePostUseCaseProvider,
      Provider<getPostsUseCase> getPostsUseCaseProvider,
      Provider<scedulePostUseCase> scedulePostUseCaseProvider,
      Provider<saveCommentUseCase> saveCommentUseCaseProvider,
      Provider<Application> contextProvider) {
    this.savePostUseCaseProvider = savePostUseCaseProvider;
    this.getPostsUseCaseProvider = getPostsUseCaseProvider;
    this.scedulePostUseCaseProvider = scedulePostUseCaseProvider;
    this.saveCommentUseCaseProvider = saveCommentUseCaseProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public PostViewModel get() {
    return newInstance(savePostUseCaseProvider.get(), getPostsUseCaseProvider.get(), scedulePostUseCaseProvider.get(), saveCommentUseCaseProvider.get(), contextProvider.get());
  }

  public static PostViewModel_Factory create(Provider<savePostUseCase> savePostUseCaseProvider,
      Provider<getPostsUseCase> getPostsUseCaseProvider,
      Provider<scedulePostUseCase> scedulePostUseCaseProvider,
      Provider<saveCommentUseCase> saveCommentUseCaseProvider,
      Provider<Application> contextProvider) {
    return new PostViewModel_Factory(savePostUseCaseProvider, getPostsUseCaseProvider, scedulePostUseCaseProvider, saveCommentUseCaseProvider, contextProvider);
  }

  public static PostViewModel newInstance(savePostUseCase savePostUseCase,
      getPostsUseCase getPostsUseCase, scedulePostUseCase scedulePostUseCase,
      saveCommentUseCase saveCommentUseCase, Application context) {
    return new PostViewModel(savePostUseCase, getPostsUseCase, scedulePostUseCase, saveCommentUseCase, context);
  }
}
