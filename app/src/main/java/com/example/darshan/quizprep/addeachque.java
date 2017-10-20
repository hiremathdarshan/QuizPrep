package com.example.darshan.quizprep;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Darshan on 7/30/2016.
 */
public class addeachque extends AsyncTask<String,Void,String> {


    Context context;
    AlertDialog alertDialog;
    addeachque (Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String url1 = "http://omega.uta.edu/~fsf3992/addquestion.php";
       // String register_url = "http://omega.uta.edu/~fsf3992/register.php";
        if (type.equals("addque")){
            try {
                String que = params[1];
                String op1 = params[2];
                String op2 = params[3];
                String op3 = params[4];
                String op4 = params[5];
                String ans = params[6];
                String id ="6";
                URL url = new URL(url1);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("quizid", "UTF-8")+"="+ URLEncoder.encode(id, "UTF-8")+"&"
                        +URLEncoder.encode("question", "UTF-8")+ "=" + URLEncoder.encode(que, "UTF-8")+"&"
                        +URLEncoder.encode("option1", "UTF-8")+ "=" + URLEncoder.encode(op1, "UTF-8")+"&"
                        +URLEncoder.encode("option2", "UTF-8")+ "=" + URLEncoder.encode(op2, "UTF-8")+"&"
                        +URLEncoder.encode("option3", "UTF-8")+ "=" + URLEncoder.encode(op3, "UTF-8")+"&"
                        +URLEncoder.encode("option4", "UTF-8")+ "=" + URLEncoder.encode(op4, "UTF-8")+"&"
                        +URLEncoder.encode("correct", "UTF-8")+ "=" + URLEncoder.encode(ans, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result1 ="";
                String line="";
                while ((line = bufferedReader.readLine())!= null){
                    result1 += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result1;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    @Override
    protected void onPostExecute(String result1) {
        //alertDialog.setMessage(result);
        //alertDialog.show();
        Toast.makeText(context,result1,Toast.LENGTH_SHORT).show();
        Intent I = new Intent(context, AddQuestion.class);
        context.startActivity(I);


    }
}
