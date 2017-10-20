package com.example.darshan.quizprep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
EditText name,username,password,type;
    RadioButton rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (EditText)findViewById(R.id.RegisterName);
        username = (EditText)findViewById(R.id.RegisterUser);
        password = (EditText)findViewById(R.id.RegisterPassword);
      //  type = (EditText)findViewById(R.id.RegisterType);
        rb = (RadioButton) findViewById(R.id.radio1);

    }

    public void OnReg(View view){
        String str_name =name.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_type = rb.getText().toString();
        String type = "Register";
        BackgroundRegister backgroundreg = new BackgroundRegister(this);
        backgroundreg.execute(type,str_name,str_username,str_password,str_type);

    }
}
