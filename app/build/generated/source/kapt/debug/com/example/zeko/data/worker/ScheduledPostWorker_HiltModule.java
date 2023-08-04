package com.example.zeko.data.worker;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = ScheduledPostWorker.class
)
public interface ScheduledPostWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.example.zeko.data.worker.ScheduledPostWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      ScheduledPostWorker_AssistedFactory factory);
}
