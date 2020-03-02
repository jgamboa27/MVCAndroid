package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvc.R
import com.example.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by jgamboa.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val provider = ViewModelProviders.of(this)
        loginViewModel = provider.get(LoginViewModel::class.java)
        loginViewModel.validUser.observe(this, Observer {
                b ->
            if (b)
                action_result.text = getString(R.string.correct_user_message)
            else
                action_result.text = getString(R.string.incorrect_user_message)
        })
        loginViewModel.filloutPersonsArray()
        initWidgets()
    }

    private fun initWidgets() {

        action_button.setOnClickListener {
            performLoginValidation()
        }
    }

    private fun performLoginValidation(){
        val userTyped = username_text.text.toString()
        val passTyped = password_text.text.toString()
        val isStudent = person_type_switch.isChecked

        loginViewModel.validateUser(if (isStudent) 1 else 0, userTyped, passTyped)
    }
}
