// Generated by Dagger (https://dagger.dev).
package com.example.zeko.di;

import com.example.zeko.data.repository.PostRepository;
import com.example.zeko.data.usecase.getPostsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UseCaseModule_ProvideGetPostUseCaseFactory implements Factory<getPostsUseCase> {
  private final UseCaseModule module;

  private final Provider<PostRepository> postRepositoryProvider;

  public UseCaseModule_ProvideGetPostUseCaseFactory(UseCaseModule module,
      Provider<PostRepository> postRepositoryProvider) {
    this.module = module;
    this.postRepositoryProvider = postRepositoryProvider;
  }

  @Override
  public getPostsUseCase get() {
    return provideGetPostUseCase(module, postRepositoryProvider.get());
  }

  public static UseCaseModule_ProvideGetPostUseCaseFactory create(UseCaseModule module,
      Provider<PostRepository> postRepositoryProvider) {
    return new UseCaseModule_ProvideGetPostUseCaseFactory(module, postRepositoryProvider);
  }

  public static getPostsUseCase provideGetPostUseCase(UseCaseModule instance,
      PostRepository postRepository) {
    return Preconditions.checkNotNullFromProvides(instance.provideGetPostUseCase(postRepository));
  }
}
