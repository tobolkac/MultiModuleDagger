package com.tobolkac.multimodulegradle.settings

import com.tobolkac.multimodulegradle.di.scopes.LoggedInUserScope
import com.tobolkac.multimodulegradle.user.UserDataRepository
import com.tobolkac.multimodulegradle.user.UserManager
import javax.inject.Inject

/**
 * SettingsViewModel is the ViewModel that [SettingsActivity] uses to handle complex logic.
 */
@LoggedInUserScope
class SettingsViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}
