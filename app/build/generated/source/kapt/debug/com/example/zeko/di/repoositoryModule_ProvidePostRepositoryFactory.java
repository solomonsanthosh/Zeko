// Generated by Dagger (https://dagger.dev).
package com.example.zeko.di;

import android.app.Application;
import com.example.zeko.data.datasource.PostLocalDataSource;
import com.example.zeko.data.datasource.PostRemoteDataSource;
import com.example.zeko.data.repository.PostRepository;
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
public final class repoositoryModule_ProvidePostRepositoryFactory implements Factory<PostRepository> {
  private final repoositoryModule module;

  private final Provider<PostRemoteDataSource> remoteDataSourceProvider;

  private final Provider<PostLocalDataSource> localDataSourceProvider;

  private final Provider<Application> contextProvider;

  public repoositoryModule_ProvidePostRepositoryFactory(repoositoryModule module,
      Provider<PostRemoteDataSource> remoteDataSourceProvider,
      Provider<PostLocalDataSource> localDataSourceProvider,
      Provider<Application> contextProvider) {
    this.module = module;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.localDataSourceProvider = localDataSourceProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public PostRepository get() {
    return providePostRepository(module, remoteDataSourceProvider.get(), localDataSourceProvider.get(), contextProvider.get());
  }

  public static repoositoryModule_ProvidePostRepositoryFactory create(repoositoryModule module,
      Provider<PostRemoteDataSource> remoteDataSourceProvider,
      Provider<PostLocalDataSource> localDataSourceProvider,
      Provider<Application> contextProvider) {
    return new repoositoryModule_ProvidePostRepositoryFactory(module, remoteDataSourceProvider, localDataSourceProvider, contextProvider);
  }

  public static PostRepository providePostRepository(repoositoryModule instance,
      PostRemoteDataSource remoteDataSource, PostLocalDataSource localDataSource,
      Application context) {
    return Preconditions.checkNotNullFromProvides(instance.providePostRepository(remoteDataSource, localDataSource, context));
  }
}
