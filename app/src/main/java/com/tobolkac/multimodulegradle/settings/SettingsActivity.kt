package com.tobolkac.multimodulegradle.settings

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tobolkac.multimodulegradle.R
import com.tobolkac.multimodulegradle.di.providers.AppComponentProvider
import com.tobolkac.multimodulegradle.di.providers.UserComponentProvider
import com.tobolkac.multimodulegradle.login.LoginActivity
import com.tobolkac.multimodulegradle.user.UserManager
import javax.inject.Inject

class SettingsActivity : AppCompatActivity() {

    @Inject
    lateinit var userManager: UserManager
    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        userManager = (application as AppComponentProvider).appComponent.userManager()
        (userManager as UserComponentProvider).userComponent?.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupViews()
    }

    private fun setupViews() {
        findViewById<Button>(R.id.refresh).setOnClickListener {
            settingsViewModel.refreshNotifications()
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            settingsViewModel.logout()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
