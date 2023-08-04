package com.example.zeko.di;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = ZekoApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface ZekoApplication_GeneratedInjector {
  void injectZekoApplication(ZekoApplication zekoApplication);
}
