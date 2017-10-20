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
public class addquizdetails extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;

    addquizdetails(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String url_create = "http://omega.uta.edu/~fsf3992/createquiz.php";
       // String register_url = "http://omega.uta.edu/~fsf3992/register.php";
        if (type.equals("add")) {
            try {
                String course = params[1];
                String topic = params[2];
                String uname= "patel";
                URL url = new URL(url_create);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("topic", "UTF-8") + "=" + URLEncoder.encode(topic, "UTF-8") + "&"
                        + URLEncoder.encode("course", "UTF-8") + "=" + URLEncoder.encode(course, "UTF-8")+ "&"
                        + URLEncoder.encode("uname", "UTF-8") + "=" + URLEncoder.encode(uname, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result1 = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
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
        Toast.makeText(context, result1, Toast.LENGTH_SHORT).show();
        Intent I = new Intent(context, AddQuestion.class);
        context.startActivity(I);


    }
}