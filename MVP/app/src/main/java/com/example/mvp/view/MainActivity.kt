package com.example.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.example.mvc.R
import com.example.mvp.MainViewContract
import com.example.mvp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by jgamboa.
 */

class MainActivity : AppCompatActivity(), MainViewContract.View {

    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)
        presenter?.filloutPersonsArray()
    }

    override fun initWidgets() {

        action_button?.setOnClickListener {
            performLoginValidation()
        }
    }

    override fun performLoginValidation(){
        val userTyped = username_text!!.text.toString()
        val passTyped = password_text!!.text.toString()
        val isStudent = person_type_switch!!.isChecked
        showValidationResult(presenter!!.validateUser(if (isStudent) 1 else 0, userTyped, passTyped))
    }

    override fun showValidationResult(isUserCorrect: Boolean){
        if (isUserCorrect)
            action_result!!.text = getString(R.string.correct_user_message)
         else
            action_result!!.text = getString(R.string.incorrect_user_message)

    }
}
