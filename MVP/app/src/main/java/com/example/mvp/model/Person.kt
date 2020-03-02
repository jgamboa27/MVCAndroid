package com.example.mvp.model

import com.example.mvp.MainViewContract

open class Person (val userName: String, val pass: String): MainViewContract.Model{

    override fun getUser(): String {
        return userName
    }

    override fun getPassword(): String {
        return pass
    }

}