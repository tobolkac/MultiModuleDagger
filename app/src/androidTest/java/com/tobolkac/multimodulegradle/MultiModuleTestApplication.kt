package com.tobolkac.multimodulegradle

import com.tobolkac.multimodulegradle.di.AppComponent
import com.tobolkac.multimodulegradle.di.DaggerTestAppComponent

class MultiModuleTestApplication : MultiModuleApplication() {

    override fun initializeComponent(): AppComponent {
        // Creates a new TestAppComponent that injects fakes types
        return DaggerTestAppComponent.create()
    }
}
