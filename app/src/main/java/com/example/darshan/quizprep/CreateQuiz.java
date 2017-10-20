package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CreateQuiz extends AppCompatActivity {

    EditText etcourse,ettopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);


    }
    public void onNext(View view) {
        etcourse = (EditText) findViewById(R.id.etselectcourse);
        ettopic = (EditText) findViewById(R.id.etselecttopic);
        String course = etcourse.getText().toString();
        String topic = ettopic.getText().toString();


        String type = "add";
        addquizdetails addquizdetails = new addquizdetails(this);
        addquizdetails.execute(type,course,topic);

        Intent I = new Intent(this, AddQuestion.class);
        startActivity(I);
        }
    }


