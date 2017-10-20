package com.example.darshan.quizprep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onSelectCourse(View view) {
        Intent I = new Intent(this, SelectCourse.class);
        startActivity(I);
    }

    public void onLogout(View view) {
        Toast.makeText(this,"Logout successfull",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, Login.class);
        startActivity(I);
    }

    public void oncreate(View view) {
        //Toast.makeText(this,"logout successfull",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, CreateQuiz.class);
        startActivity(I);
    }
    public void onviewresult(View view) {
        Toast.makeText(this,"View all result",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, ViewResult.class);
        startActivity(I);
    }


}

