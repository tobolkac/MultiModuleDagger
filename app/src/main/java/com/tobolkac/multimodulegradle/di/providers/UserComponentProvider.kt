package com.tobolkac.multimodulegradle.di.providers

import com.tobolkac.multimodulegradle.di.subcomponents.UserComponent

interface UserComponentProvider {
    val userComponent: UserComponent?
}