package com.jgr.android.loginformdemo;

/**
 * Created by jgamboa on 12/5/16.
 */

public class Professor extends Person {

    private String professorId;

    public Professor(String username, String pass, String professorId){
        super(username, pass);
        this.professorId = professorId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
}
