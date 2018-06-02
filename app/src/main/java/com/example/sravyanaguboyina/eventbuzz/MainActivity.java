package com.example.sravyanaguboyina.eventbuzz;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static Button button_signup,button_login,button_stafflogin;
    EditText UsernameEt,PasswordEt;
    public static int variable;
     public String  str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
        UsernameEt = (EditText) findViewById(R.id.username);
        PasswordEt = (EditText) findViewById(R.id.password);
    }



    public void OnClickButtonListener(){
        button_signup = (Button) findViewById(R.id.signup);
        button_login = (Button) findViewById(R.id.login);
        button_stafflogin=(Button)findViewById(R.id.logint);
        button_signup.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.select");
                        startActivity(intent);
                    }
                }
        );
        button_login.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                         if(onLogin(view)){
                              Log.d("LOG_TAG","Entered IF of onlogin()");
                                Intent intent = new Intent("com.example.sravyanaguboyina.eventbuzz.student_choose");
                                startActivity(intent);
                        }
                    }
                }
        );
        button_stafflogin.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        if(onStaffLogin(view))
                        {
                                Intent intent = new Intent(MainActivity.this, staffpage.class);
                                startActivity(intent);
                        }
                    }
                }
        );

    }
    public boolean onLogin(View view ){
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,username,password);
        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(MainActivity.this, "Complete All The Fields", Toast.LENGTH_SHORT).show();
        }
       // Log.d("LOG_TAG", backgroundWorker.val);
        Log.d("LOG_TAGGG", String.valueOf(variable));
       if(variable==1) {
           Log.d("LOG_TAG","Entered IF of mainactivity");
           return true;
       }
        return false;
    }

    public boolean onStaffLogin(View view ){
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "stafflogin";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,username,password);
        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(MainActivity.this, "Complete All The Fields", Toast.LENGTH_SHORT).show();
        }
        if(variable==1) {
            Log.d("LOG_TAG","Entered IF of mainactivity");
            return true;
        }
        return false;
    }
}
