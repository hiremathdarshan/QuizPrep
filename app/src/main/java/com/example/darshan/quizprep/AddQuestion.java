package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestion extends AppCompatActivity {

    EditText que,op1,op2,op3,op4,ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void nextque(View view) {


        que= (EditText) findViewById(R.id.etquestion);
        op1= (EditText) findViewById(R.id.etoption1);
        op2= (EditText) findViewById(R.id.etoption2);
        op3= (EditText) findViewById(R.id.etoption3);
        op4= (EditText) findViewById(R.id.etoption4);
        ans= (EditText) findViewById(R.id.etanswer);

        String que1 = que.getText().toString();
        String opt1 = op1.getText().toString();
        String opt2 = op2.getText().toString();
        String opt3 = op3.getText().toString();
        String opt4 = op4.getText().toString();
        String ans1 = ans.getText().toString();
        String type = "addque";
        addeachque addeachque1 = new addeachque(this);
        addeachque1.execute(type,que1,opt1,opt2,opt3,opt4,ans1);

        //que.setText("");
        //op1.setText("");
        //op2.setText("");
        //op3.setText("");
        //op4.setText("");
        //ans.setText("");
    }

    public void onsubmit(View view) {

        Toast.makeText(this,"Quiz Created..!!",Toast.LENGTH_SHORT).show();

        Intent I = new Intent(this, HomePage.class);

        this.startActivity(I);


    }
}
