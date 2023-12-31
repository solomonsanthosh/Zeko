// Generated by Dagger (https://dagger.dev).
package com.example.zeko.di;

import com.example.zeko.data.api.PostService;
import com.example.zeko.data.datasource.PostRemoteDataSource;
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
public final class repoositoryModule_ProvidePostRemoteDataSourceFactory implements Factory<PostRemoteDataSource> {
  private final repoositoryModule module;

  private final Provider<PostService> postServiceProvider;

  public repoositoryModule_ProvidePostRemoteDataSourceFactory(repoositoryModule module,
      Provider<PostService> postServiceProvider) {
    this.module = module;
    this.postServiceProvider = postServiceProvider;
  }

  @Override
  public PostRemoteDataSource get() {
    return providePostRemoteDataSource(module, postServiceProvider.get());
  }

  public static repoositoryModule_ProvidePostRemoteDataSourceFactory create(
      repoositoryModule module, Provider<PostService> postServiceProvider) {
    return new repoositoryModule_ProvidePostRemoteDataSourceFactory(module, postServiceProvider);
  }

  public static PostRemoteDataSource providePostRemoteDataSource(repoositoryModule instance,
      PostService postService) {
    return Preconditions.checkNotNullFromProvides(instance.providePostRemoteDataSource(postService));
  }
}
