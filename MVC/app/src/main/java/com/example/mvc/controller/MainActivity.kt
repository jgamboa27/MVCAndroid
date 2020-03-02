package com.example.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.example.mvc.model.Person
import com.example.mvc.model.Professor
import com.example.mvc.model.Student
import com.example.mvc.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

/**
 * Created by jgamboa.
 */

class MainActivity : AppCompatActivity() {

    private var persons: ArrayList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons = ArrayList()
        persons!!.add(Professor("Jason", "password1234", "JGR"))
        persons!!.add(Student("Maria", "M1234Pas$", 20145548))
        initWidgets()
    }

    private fun initWidgets() {
        action_button!!.setOnClickListener {
            if (!person_type_switch!!.isChecked) {
                validateUser(persons!![0])
            } else {
                validateUser(persons!![1])
            }
        }
    }

    private fun validateUser(person: Person) {
        val userNameTyped = username_text!!.text.toString()
        val passwordTyped = password_text!!.text.toString()
        if (userNameTyped == person.userName && passwordTyped == person.pass) {
            action_result!!.text = getString(R.string.correct_user_message)
        } else {
            action_result!!.text = getString(R.string.incorrect_user_message)
        }
    }
}
