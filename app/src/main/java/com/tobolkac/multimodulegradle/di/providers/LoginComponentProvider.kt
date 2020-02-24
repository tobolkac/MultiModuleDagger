package com.tobolkac.multimodulegradle.di.providers

import com.tobolkac.multimodulegradle.di.subcomponents.LoginComponent

interface LoginComponentProvider {
    val loginComponent: LoginComponent
}