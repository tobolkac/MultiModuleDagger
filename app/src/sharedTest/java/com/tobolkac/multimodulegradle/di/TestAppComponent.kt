package com.tobolkac.multimodulegradle.di

import com.tobolkac.multimodulegradle.di.modules.AppSubComponents
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestStorageModule::class,
    AppSubComponents::class
])
interface TestAppComponent : AppComponent