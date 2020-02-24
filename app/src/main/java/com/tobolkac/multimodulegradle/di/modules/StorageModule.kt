package com.tobolkac.multimodulegradle.di.modules

import com.tobolkac.multimodulegradle.storage.SharedPreferencesStorage
import com.tobolkac.multimodulegradle.storage.Storage
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}