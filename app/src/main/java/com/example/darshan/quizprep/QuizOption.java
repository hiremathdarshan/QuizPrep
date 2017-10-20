package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class QuizOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void onLogout(View view) {
        Toast.makeText(this,"logout successfull",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, Login.class);
        startActivity(I);
    }

    public void onReview(View view) {
        Toast.makeText(this,"Review it...",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, ReviewCode.class);
        startActivity(I);
    }

    public void onTakeQuiz(View view) {
        Toast.makeText(this,"start answering...",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, TakeSelectedQuiz.class);
        startActivity(I);
    }
}
