package com.example.sravyanaguboyina.eventbuzz;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;
import java.util.List;

public class student_view extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter2 adapter;
    private List<MyData2> data_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        data_list = new ArrayList<>();
        BackgroundTask task = new BackgroundTask(this);
        task.execute();
    }
    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        private String JSON_STRING = "";
        String json_url;
        Context ctx;


        BackgroundTask(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        protected void onPreExecute() {
            json_url = "http://192.168.43.206/eventbuzzphp/studentview.php";
            Log.d("LOG_TAG", json_url);
        }

        @Override
        protected String doInBackground(Void... params) {

            try {

                URL url = new URL(json_url);
                Log.d("LOG_TAG", url.toString());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //Log.d("LOG_TAG", String.valueOf(httpURLConnection.getResponseCode()));
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String user_name=backgroundWorker.username;
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+ URLEncoder.encode(user_name,"UTF-8");
                Log.d("LOG_TAG_fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream, "iso-8859-1"));
                StringBuilder stringBuilder = new StringBuilder();

                String response = "";
                String line = "";
                while ((JSON_STRING = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_STRING + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("LOG_TAG1", stringBuilder.toString());
                return stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String result) {


            try {
                Log.d("LOG_TAG","entered try");
                JSONObject base_json = new JSONObject(result);
                JSONArray a = base_json.getJSONArray("server_response");
                int i = 0;
                while (i < a.length()) {
                    Log.d("LOG_TAG","entered while");
                    JSONObject object = a.getJSONObject(i);

                    MyData2 data = new MyData2(object.getString("empid"),object.getString("descr"),
                            object.getString("date"),object.getString("time"),object.getString("semester"),object.getString("branch"));
                    Log.d("LOG_TAG",object.getString("empid")+object.getString("descr")+
                            object.getString("date")+object.getString("time")+object.getString("semester")+
                            object.getString("branch"));

                    data_list.add(i,data);
                    i++;
                }
                recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);
                gridLayoutManager = new GridLayoutManager(student_view.this, 1);
                recyclerView.setLayoutManager(gridLayoutManager);

                adapter = new CustomAdapter2(student_view.this, data_list);
                recyclerView.setAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
