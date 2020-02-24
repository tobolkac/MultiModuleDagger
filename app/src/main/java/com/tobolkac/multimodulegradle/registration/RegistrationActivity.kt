package com.tobolkac.multimodulegradle.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tobolkac.multimodulegradle.R
import com.tobolkac.multimodulegradle.di.providers.AppComponentProvider
import com.tobolkac.multimodulegradle.di.providers.RegistrationComponentProvider
import com.tobolkac.multimodulegradle.di.subcomponents.RegistrationComponent
import com.tobolkac.multimodulegradle.main.MainActivity
import com.tobolkac.multimodulegradle.registration.enterdetails.EnterDetailsFragment
import com.tobolkac.multimodulegradle.registration.termsandconditions.TermsAndConditionsFragment
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity(), RegistrationComponentProvider {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    override val registrationComponent: RegistrationComponent by lazy {
        (application as AppComponentProvider).appComponent.registrationComponentFactory().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        registrationComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registration)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }

    /**
     * Callback from EnterDetailsFragment when username and password has been entered
     */
    fun onDetailsEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    /**
     * Callback from T&CsFragment when TCs have been accepted
     */
    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
