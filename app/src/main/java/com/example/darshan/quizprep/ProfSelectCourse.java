package com.example.darshan.quizprep;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
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

public class ProfSelectCourse extends AppCompatActivity {

    private String jsonResult;
    private String url = "http://omega.uta.edu/~fsf3992/quizlist.php";
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_select_course);

        lv = (ListView) findViewById(R.id.listView);

        accessWebService();

    }
    public void onsubmit(View view)
    {
        Toast.makeText(this,"quiz verified",Toast.LENGTH_LONG).show();
        Intent I = new Intent(this, HomePage.class);
        startActivity(I);

    }

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


    public void ListDrwaer() {

        List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();
        String que,op1,op2,op3,op4,ans;

        String topic[]={"hello","hello","hello","hello"};
        String userid[]={"hello","hello","hello","hello"};
        String time[]={"hello","hello","hello","hello"};



        try {

            JSONArray jsonResponse = new JSONArray(jsonResult);

            for (int i = 0; i < jsonResponse.length(); i++) {

                JSONObject jsonChildNode = jsonResponse.getJSONObject(i);

                que = jsonChildNode.optString("quiz_topic").toString();

                op1 = jsonChildNode.optString("creator_userid").toString();

                op2 = jsonChildNode.optString("timestamp").toString();


                topic[i]=que;
                userid[i]=op1;
                time[i]=op2;


                //String output = que1[i]+op11[i]+op22[i]+op33[i]+op44[i]+ans1[i];

                // employeeList.add(createEmployee("employees", output));

            }

        } catch (JSONException e) {

            Toast.makeText(getApplicationContext(), "Error" + e.toString(),

                    Toast.LENGTH_SHORT).show();

        }


      /*  SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList,

                android.R.layout.simple_list_item_1,

                new String[]{"employees"}, new int[]{android.R.id.text1});

        lv.setAdapter(simpleAdapter);

        lv.setTextFilterEnabled(true);*/
        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapterForProfCourse(this,topic ,userid,time));

    }



    private HashMap<String, String> createEmployee(String name, String number) {

        HashMap<String, String> employeeNameNo = new HashMap<String, String>();

        employeeNameNo.put(name, number);

        return employeeNameNo;

    }

}
