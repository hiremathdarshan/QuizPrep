package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCourse extends AppCompatActivity {
    private String jsonResult;

    private String url = "http://omega.uta.edu/~fsf3992/course.php";

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course);

        listView = (ListView) findViewById(R.id.listView1);

        accessWebService();

    }
    // Async Task to access the web

    private class JsonReadTask extends AsyncTask<String, Void, String> {

        @Override

        protected String doInBackground(String... params) {

            HttpClient httpclient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost(params[0]);

            try {

                HttpResponse response = httpclient.execute(httppost);

                jsonResult = inputStreamToString(response.getEntity().getContent()).toString();

            }




            catch (ClientProtocolException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;

        }




        private StringBuilder inputStreamToString(InputStream is) {

            String rLine = "";

            StringBuilder answer = new StringBuilder();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));




            try {

                while ((rLine = rd.readLine()) != null) {

                    answer.append(rLine);

                }

            }




            catch (IOException e) {

                // e.printStackTrace();

                Toast.makeText(getApplicationContext(),

                        "Error..." + e.toString(), Toast.LENGTH_LONG).show();

            }

            return answer;

        }




        @Override

        protected void onPostExecute(String result) {

            ListDrwaer();

        }


    }// end async task
    public void accessWebService() {

        JsonReadTask task = new JsonReadTask();

        // passes values for the urls string array

        task.execute(new String[] { url });

    }
    // build hash set for list view

    public void ListDrwaer() {

        List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();


        try {

            JSONArray jsonResponse = new JSONArray(jsonResult);

            // JSONArray jsonMainNode = jsonResponse.getJSONArray("courses");


            for (int i = 0; i < jsonResponse.length(); i++) {

                JSONObject jsonChildNode = jsonResponse.getJSONObject(i);

                String name = jsonChildNode.optString("C_id");

                String number = jsonChildNode.optString("C_name");

                String outPut = name + "-" + number;

                employeeList.add(createEmployee("employees", outPut));

            }

        } catch (JSONException e) {

            Toast.makeText(getApplicationContext(), "Error" + e.toString(),

                    Toast.LENGTH_SHORT).show();

        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList,

                android.R.layout.simple_list_item_1,

                new String[]{"employees"}, new int[]{android.R.id.text1});

        listView.setAdapter(simpleAdapter);

        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position) {
                    case 0:
                        Intent ab = new Intent(SelectCourse.this, QuizList.class);
                        startActivity(ab);
                        break;
                    case 1:
                        Intent ba = new Intent(SelectCourse.this, ProfSelectCourse.class);
                        startActivity(ba);
                        break;
                }
            }
            //  Toast.makeText(getApplication(), "c", Toast.LENGTH_SHORT).show();


        });
    }



    private HashMap<String, String> createEmployee(String name, String number) {

        HashMap<String, String> employeeNameNo = new HashMap<String, String>();

        employeeNameNo.put(name, number);

        return employeeNameNo;

    }
    public void onLogout(View view) {
        Toast.makeText(this,"logout successfull",Toast.LENGTH_SHORT).show();
        Intent I = new Intent(this, Login.class);
        startActivity(I);
    }


}
