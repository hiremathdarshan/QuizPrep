package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ViewQuizScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_quiz_score);

    }

    public void onReview(View view) {
        Toast.makeText(this,"review your answers",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, ReviewCode.class);
        startActivity(I);
    }

}
