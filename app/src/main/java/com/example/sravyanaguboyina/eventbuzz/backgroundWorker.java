package com.example.sravyanaguboyina.eventbuzz;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;

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
 * Created by sravya naguboyina on 16-01-2018.
 */

public class backgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    public static String username;
    public String val="";
    AlertDialog alertDailog;
    backgroundWorker (Context ctx){  //constructor
        context=ctx;
    }
    @Override
    protected String doInBackground(String ... params) {
        String type=params[0];
        String login_url="http://192.168.43.206/eventbuzzphp/studentlogin.php";
        String register_url="http://192.168.43.206/eventbuzzphp/studentsignup.php";
        String empregister_url="http://192.168.43.206/eventbuzzphp/empsignup.php";
        String emplogin_url="http://192.168.43.206/eventbuzzphp/emplogin.php";
        String staffcond_url="http://192.168.43.206/eventbuzzphp/staffconduct.php";
        String UPLOAD_URL="http://192.168.43.206/eventbuzzphp/studentconduct.php";
        if(type.equals("login")){
            try {
                    Log.d("HIIIIII",type);
                    String user_name=params[1];
                    username = user_name;
                    String password=params[2];
                    Log.e("hi",user_name);
                    Log.e("yo",password);

                    URL url=new URL(login_url);
                    //build connection  HttpURLConnection
                    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream= httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                    String post_data= URLEncoder.encode("user_name","UTF-8")+"="+ URLEncoder.encode(user_name,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+ URLEncoder.encode(password,"UTF-8") ;
                    Log.d("fi",post_data);
                    //write post adat to buffered writer;
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    //result will be read by buffered reader;
                    String result="";
                    String line="";
                    while((line = bufferedReader.readLine())!=null){
                        result+=line;
                    }
                    // Log.d("line",line);
                    Log.d("LOG_TAG",result);
                   MainActivity.variable=fun(result);

                    Log.d("LOG_TAG",val);
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                   // return val;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

      else  if(type.equals("stafflogin")){
            try {
                Log.d("HIIIIII",type);
                String user_name=params[1];
                String password=params[2];
                Log.d("hi",user_name);
                Log.d("yo",password);
                URL url=new URL(emplogin_url);
                //build connection  HttpURLConnection
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+ URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+ URLEncoder.encode(password,"UTF-8") ;
                Log.d("fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //result will be read by buffered reader;
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
               // Log.d("line",line);
                Log.d("vi",result);
                Log.d("LOG_TAG",result);
                MainActivity.variable=fun(result);
               // val=fun(result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (type.equals("register")){
            try {
                Log.d("HIIIIII",type);
                String user_name=params[1];
                String password=params[2];
                String email_id= params[3];
                String phone_num=params[4];
                String semester=params[5];
                String bran=params[6];
                Log.d("hi",user_name);
                Log.d("yo",password);
                URL url=new URL(register_url);
                //build connection  HttpURLConnection
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+ URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+ URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("email_id","UTF-8")+"="+ URLEncoder.encode(email_id,"UTF-8")+"&"
                        +URLEncoder.encode("phone_num","UTF-8")+"="+ URLEncoder.encode(phone_num,"UTF-8")+"&"
                        +URLEncoder.encode("semester","UTF-8")+"="+ URLEncoder.encode(semester,"UTF-8")+"&"
                        +URLEncoder.encode("bran","UTF-8")+"="+ URLEncoder.encode(bran,"UTF-8");
                Log.d("fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //result will be read by buffereed redaer;
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                Log.d("vi",result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (type.equals("conduct")){
            try {
                Log.d("HIIIIII",type);
                String emp_id=params[1];
                String descr=params[2];
                String date= params[3];
                String time=params[4];
                String semester=params[5];
                String bran=params[6];
                Log.d("hi",emp_id);
                Log.d("yo",descr);
                URL url=new URL(staffcond_url);
                //build connection  HttpURLConnection
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("emp_id","UTF-8")+"="+ URLEncoder.encode(emp_id,"UTF-8")+"&"
                        +URLEncoder.encode("descr","UTF-8")+"="+ URLEncoder.encode(descr,"UTF-8")+"&"
                        +URLEncoder.encode("date","UTF-8")+"="+ URLEncoder.encode(date,"UTF-8")+"&"
                        +URLEncoder.encode("time","UTF-8")+"="+ URLEncoder.encode(time,"UTF-8")+"&"
                        +URLEncoder.encode("semester","UTF-8")+"="+ URLEncoder.encode(semester,"UTF-8")+"&"
                        +URLEncoder.encode("bran","UTF-8")+"="+ URLEncoder.encode(bran,"UTF-8");
                Log.d("fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //result will be read by buffereed redaer;
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                Log.d("vi",result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("emp_register")){
            try {
                Log.d("HIIIIII",type);
                String user_name=params[1];
                String password=params[2];
                String empname=params[3];
                String email_id= params[4];
                String phone_num=params[5];
                String position=params[6];
                String dpt=params[7];
                Log.d("hi",user_name);
                Log.d("yo",password);
                URL url=new URL(empregister_url);
                //build connection  HttpURLConnection
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("user_name","UTF-8")+"="+ URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+ URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("empname","UTF-8")+"="+ URLEncoder.encode(empname,"UTF-8")+"&"
                        +URLEncoder.encode("email_id","UTF-8")+"="+ URLEncoder.encode(email_id,"UTF-8")+"&"
                        +URLEncoder.encode("phone_num","UTF-8")+"="+ URLEncoder.encode(phone_num,"UTF-8")+"&"
                        +URLEncoder.encode("position","UTF-8")+"="+ URLEncoder.encode(position,"UTF-8")+"&"
                        +URLEncoder.encode("dpt","UTF-8")+"="+ URLEncoder.encode(dpt,"UTF-8");
                Log.d("fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //result will be read by buffereed redaer;
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                Log.d("vi",result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type=="student_conduct"){
            try {
                Log.d("HIIIIII",type);
                String name=params[1];
                String description=params[2];
                String venue=params[3];
                String s_date= params[4];
                String s_time=params[5];
                String e_date=params[6];
                String e_time=params[7];
               // String image_name=params[8];
               // String upload_url=params[9];
               // Log.d("hi",user_name);
               // Log.d("yo",password);
                URL url=new URL(UPLOAD_URL);
                //build connection  HttpURLConnection
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream= httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));//UTF-8 IS DATATYPE
                String post_data= URLEncoder.encode("name","UTF-8")+"="+ URLEncoder.encode(name,"UTF-8")+"&"
                        +URLEncoder.encode("description","UTF-8")+"="+ URLEncoder.encode(description,"UTF-8")+"&"
                        +URLEncoder.encode("venue","UTF-8")+"="+ URLEncoder.encode(venue,"UTF-8")+"&"
                        +URLEncoder.encode("s_date","UTF-8")+"="+ URLEncoder.encode(s_date,"UTF-8")+"&"
                        +URLEncoder.encode("s_time","UTF-8")+"="+ URLEncoder.encode(s_time,"UTF-8")+"&"
                        +URLEncoder.encode("e_date","UTF-8")+"="+ URLEncoder.encode(e_date,"UTF-8")+"&"
                        +URLEncoder.encode("e_time","UTF-8")+"="+ URLEncoder.encode(e_time,"UTF-8");
                Log.d("fi",post_data);
                //write post adat to buffered writer;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                //result will be read by buffereed redaer;
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result+=line;
                }
                Log.d("vi",result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onPreExecute(){
        //alertDailog =new AlertDialog.Builder(context).create();
        // alertDailog.setTitle("Login Status");
    }

    protected void onPostExecute(String result){
        //alertDailog.setMessage(result);
        //alertDailog.show();
        //Log.e("err123",result);
      //  val = result;
      //  Log.e("login_value",val);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    public int fun(String s){
        Log.d("LOG_TAG","entered fun function");
        Log.d("LOG_TAG",s);
        Log.d("LOG_TAG", String.valueOf(s.compareTo("login success")));
        if(s.compareTo("login success")==0) {
            Log.d("LOG_TAG", "entered if in fun");
           // MainActivity.variable=1;
            return 1;
        }
        else {
         // MainActivity.variable=0;
            return 0;
        }
    }
}


