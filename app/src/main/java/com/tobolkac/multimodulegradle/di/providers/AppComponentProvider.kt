package com.tobolkac.multimodulegradle.di.providers

import com.tobolkac.multimodulegradle.di.AppComponent

interface AppComponentProvider {
    val appComponent: AppComponent
}