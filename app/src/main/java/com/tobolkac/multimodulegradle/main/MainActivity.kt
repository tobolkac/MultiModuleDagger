package com.tobolkac.multimodulegradle.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tobolkac.multimodulegradle.R
import com.tobolkac.multimodulegradle.di.providers.AppComponentProvider
import com.tobolkac.multimodulegradle.di.providers.UserComponentProvider
import com.tobolkac.multimodulegradle.login.LoginActivity
import com.tobolkac.multimodulegradle.registration.RegistrationActivity
import com.tobolkac.multimodulegradle.settings.SettingsActivity
import com.tobolkac.multimodulegradle.user.UserManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var userManager: UserManager

    @Inject
    lateinit var mainViewModel: MainViewModel

    /**
     * If the User is not registered, RegistrationActivity will be launched,
     * If the User is not logged in, LoginActivity will be launched,
     * else carry on with MainActivity
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        userManager = (application as AppComponentProvider).appComponent.userManager()
        (userManager as UserComponentProvider).userComponent?.inject(this)

        super.onCreate(savedInstanceState)

        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)
            setupViews()
        }
    }

    /**
     * Updating unread notifications onResume because they can get updated on SettingsActivity
     */
    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.notifications).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.logout).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
