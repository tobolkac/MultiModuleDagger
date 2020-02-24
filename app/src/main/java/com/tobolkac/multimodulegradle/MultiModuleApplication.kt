package com.tobolkac.multimodulegradle

import android.app.Application
import com.tobolkac.multimodulegradle.di.AppComponent
import com.tobolkac.multimodulegradle.di.DaggerAppComponent
import com.tobolkac.multimodulegradle.di.providers.AppComponentProvider

open class MultiModuleApplication : Application(), AppComponentProvider {

    override val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}
