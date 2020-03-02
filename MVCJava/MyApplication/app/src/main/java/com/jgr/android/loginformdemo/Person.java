package com.jgr.android.loginformdemo;

/**
 * Created by jgamboa on 12/5/16.
 */

public class Person {

    protected String username;
    protected String pass;

    public Person(String username, String pass){
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
