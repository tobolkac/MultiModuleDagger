package com.tobolkac.multimodulegradle.di.subcomponents

import com.tobolkac.multimodulegradle.di.scopes.ActivityScope
import com.tobolkac.multimodulegradle.registration.RegistrationActivity
import com.tobolkac.multimodulegradle.registration.enterdetails.EnterDetailsFragment
import com.tobolkac.multimodulegradle.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }
}