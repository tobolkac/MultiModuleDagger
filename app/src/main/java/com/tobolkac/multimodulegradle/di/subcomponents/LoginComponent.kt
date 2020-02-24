package com.tobolkac.multimodulegradle.di.subcomponents

import com.tobolkac.multimodulegradle.di.scopes.ActivityScope
import com.tobolkac.multimodulegradle.login.LoginActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    fun inject(activity: LoginActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }
}