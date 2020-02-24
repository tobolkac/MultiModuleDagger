package com.tobolkac.multimodulegradle.di

import com.tobolkac.multimodulegradle.storage.FakeStorage
import com.tobolkac.multimodulegradle.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class TestStorageModule {

    // Makes Dagger provide FakeStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}