package com.tobolkac.multimodulegradle.di.subcomponents

import com.tobolkac.multimodulegradle.di.scopes.LoggedInUserScope
import com.tobolkac.multimodulegradle.main.MainActivity
import com.tobolkac.multimodulegradle.settings.SettingsActivity
import dagger.Subcomponent

@LoggedInUserScope
@Subcomponent
interface UserComponent {

    fun inject(activity: MainActivity)
    fun inject(activity: SettingsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UserComponent
    }
}