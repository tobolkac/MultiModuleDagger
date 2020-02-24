package com.tobolkac.multimodulegradle.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import com.tobolkac.multimodulegradle.R
import com.tobolkac.multimodulegradle.di.providers.AppComponentProvider
import com.tobolkac.multimodulegradle.di.providers.LoginComponentProvider
import com.tobolkac.multimodulegradle.di.subcomponents.LoginComponent
import com.tobolkac.multimodulegradle.main.MainActivity
import com.tobolkac.multimodulegradle.registration.RegistrationActivity
import com.tobolkac.multimodulegradle.user.UserManager
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginComponentProvider {

    @Inject
    lateinit var userManager: UserManager
    @Inject
    lateinit var loginViewModel: LoginViewModel

    override val loginComponent: LoginComponent by lazy {
        (application as AppComponentProvider).appComponent.loginComponentFactory().create()
    }

    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        loginComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Creates ViewModel and listens for the loginState LiveData
        loginViewModel.loginState.observe(this, Observer<LoginViewState> { state ->
            when (state) {
                is LoginSuccess -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                is LoginError -> errorTextView.visibility = View.VISIBLE
            }
        })

        errorTextView = findViewById(R.id.error)
        setupViews()
    }

    private fun setupViews() {
        val usernameEditText = findViewById<EditText>(R.id.username)
        usernameEditText.isEnabled = false
        usernameEditText.setText(loginViewModel.getUsername())

        val passwordEditText = findViewById<EditText>(R.id.password)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        findViewById<Button>(R.id.login).setOnClickListener {
            loginViewModel.login(usernameEditText.text.toString(), passwordEditText.text.toString())
        }
        findViewById<Button>(R.id.unregister).setOnClickListener {
            loginViewModel.unregister()
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}

sealed class LoginViewState
object LoginSuccess : LoginViewState()
object LoginError : LoginViewState()
