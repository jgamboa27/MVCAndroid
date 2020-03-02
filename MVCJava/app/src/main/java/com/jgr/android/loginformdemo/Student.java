package com.jgr.android.loginformdemo;

/**
 * Created by jgamboa on 12/5/16.
 */

public class Student extends Person {

    private int studentId;

    public Student(String username, String pass, int studentId){
        super(username, pass);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
