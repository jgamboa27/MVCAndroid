package com.example.mvp

interface MainViewContract {

    interface View {
        fun initWidgets()
        fun performLoginValidation()
        fun showValidationResult(isUserCorrect: Boolean)
    }

    interface Presenter {
        fun filloutPersonsArray()
        fun validateUser(personIndex: Int, userTyped: String, passTyped: String): Boolean
    }

    interface Model {
        fun getUser(): String
        fun getPassword(): String
    }
}