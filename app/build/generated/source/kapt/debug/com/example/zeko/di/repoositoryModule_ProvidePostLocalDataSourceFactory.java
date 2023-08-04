// Generated by Dagger (https://dagger.dev).
package com.example.zeko.di;

import com.example.zeko.data.datasource.PostLocalDataSource;
import com.example.zeko.data.db.PostDao;
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
public final class repoositoryModule_ProvidePostLocalDataSourceFactory implements Factory<PostLocalDataSource> {
  private final repoositoryModule module;

  private final Provider<PostDao> postDaoProvider;

  public repoositoryModule_ProvidePostLocalDataSourceFactory(repoositoryModule module,
      Provider<PostDao> postDaoProvider) {
    this.module = module;
    this.postDaoProvider = postDaoProvider;
  }

  @Override
  public PostLocalDataSource get() {
    return providePostLocalDataSource(module, postDaoProvider.get());
  }

  public static repoositoryModule_ProvidePostLocalDataSourceFactory create(repoositoryModule module,
      Provider<PostDao> postDaoProvider) {
    return new repoositoryModule_ProvidePostLocalDataSourceFactory(module, postDaoProvider);
  }

  public static PostLocalDataSource providePostLocalDataSource(repoositoryModule instance,
      PostDao postDao) {
    return Preconditions.checkNotNullFromProvides(instance.providePostLocalDataSource(postDao));
  }
}
