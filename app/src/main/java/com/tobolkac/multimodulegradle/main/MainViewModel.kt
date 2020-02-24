package com.tobolkac.multimodulegradle.main

import com.tobolkac.multimodulegradle.di.scopes.LoggedInUserScope
import com.tobolkac.multimodulegradle.user.UserDataRepository
import javax.inject.Inject

/**
 * MainViewModel is the ViewModel that [MainActivity] uses to
 * obtain information of what to show on the screen.
 */
@LoggedInUserScope
class MainViewModel @Inject constructor(private val userDataRepository: UserDataRepository) {

    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unreadNotifications} unread notifications"
}
