package com.example.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.Person
import com.example.mvvm.model.Professor
import com.example.mvvm.model.Student

class LoginViewModel: ViewModel() {


    var validUser: MutableLiveData<Boolean> = MutableLiveData()

    private var persons: ArrayList<Person>? = null


    fun filloutPersonsArray(){
        persons = java.util.ArrayList()
        persons!!.add(Professor("Jason", "password1234", "JGR"))
        persons!!.add(Student("Maria", "M1234Pas$", 20145548))
    }

    fun validateUser(personIndex: Int, userTyped: String, passTyped: String){
        if (userTyped == persons!![personIndex].userName && passTyped == persons!![personIndex].pass) {
             validUser.postValue(true)
        } else {
            validUser.postValue(false)
        }
    }
}