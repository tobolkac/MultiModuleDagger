package com.tobolkac.multimodulegradle.di

import android.content.Context
import com.tobolkac.multimodulegradle.di.modules.AppSubComponents
import com.tobolkac.multimodulegradle.di.modules.StorageModule
import com.tobolkac.multimodulegradle.di.subcomponents.LoginComponent
import com.tobolkac.multimodulegradle.di.subcomponents.RegistrationComponent
import com.tobolkac.multimodulegradle.di.subcomponents.UserComponent
import com.tobolkac.multimodulegradle.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    StorageModule::class,
    AppSubComponents::class
])
interface AppComponent {


    fun registrationComponentFactory(): RegistrationComponent.Factory
    fun loginComponentFactory(): LoginComponent.Factory
    fun userComponentFactory(): UserComponent.Factory

    fun userManager(): UserManager

    /*
        Could also be:

        @Component.Builder
        interface Builder {
            @BindsInstance
            fun context(context: Context): Builder
            fun build(): AppComponent
        }
     */
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}