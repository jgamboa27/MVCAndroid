package com.example.mvp.presenter

import com.example.mvp.MainViewContract
import com.example.mvp.model.Professor
import com.example.mvp.model.Student
import java.util.ArrayList

class MainActivityPresenter(_view: MainViewContract.View): MainViewContract.Presenter {

    private var view: MainViewContract.View = _view
    private var persons: ArrayList<MainViewContract.Model>? = null

    init {
        view.initWidgets()
    }

    override fun filloutPersonsArray(){
        persons = ArrayList()
        persons!!.add(Professor("Jason", "password1234", "JGR"))
        persons!!.add(Student("Maria", "M1234Pas$", 20145548))
    }

    override fun validateUser(personIndex: Int, userTyped: String, passTyped: String): Boolean {
        return userTyped == persons!![personIndex].getUser() && passTyped == persons!![personIndex].getPassword()
    }

}