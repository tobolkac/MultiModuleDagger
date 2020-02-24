package com.tobolkac.multimodulegradle.di.modules

import com.tobolkac.multimodulegradle.di.subcomponents.LoginComponent
import com.tobolkac.multimodulegradle.di.subcomponents.RegistrationComponent
import com.tobolkac.multimodulegradle.di.subcomponents.UserComponent
import dagger.Module

@Module(subcomponents = [
    RegistrationComponent::class,
    LoginComponent::class,
    UserComponent::class
])
class AppSubComponents