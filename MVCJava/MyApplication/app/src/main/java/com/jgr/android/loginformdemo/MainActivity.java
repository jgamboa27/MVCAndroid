package com.jgr.android.loginformdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Person> persons;
    private TextView resultMessage;
    private Button validateButton;
    private Switch personTypeSwitch;
    private EditText userNameEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persons = new ArrayList<>();
        persons.add(new Professor("Jason", "password1234", "JGR"));
        persons.add(new Student("Maria", "M1234Pas$", 20145548));
        initWidgets();

    }

    private void initWidgets(){
        resultMessage = (TextView) findViewById(R.id.action_result);
        userNameEditText = (EditText) findViewById(R.id.username_text);
        passwordEditText = (EditText) findViewById(R.id.password_text);
        personTypeSwitch = (Switch) findViewById(R.id.person_type_switch);
        validateButton = (Button) findViewById(R.id.action_button);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!personTypeSwitch.isChecked()){
                   validateUser(persons.get(0));
                } else{
                   validateUser(persons.get(1));
                }
            }
        });
    }

    private void validateUser(Person person){
        String userNameTyped = userNameEditText.getText().toString();
        String passwordTyped = passwordEditText.getText().toString();
        if((userNameTyped.equals(person.getUsername())) &&
                (passwordTyped.equals(person.getPass()))){
            resultMessage.setText(getString(R.string.correct_user_message));
        } else {
            resultMessage.setText(getString(R.string.incorrect_user_message));
        }
    }
}
