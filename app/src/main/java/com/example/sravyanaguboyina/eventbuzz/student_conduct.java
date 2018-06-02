package com.example.sravyanaguboyina.eventbuzz;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

public class student_conduct extends AppCompatActivity {
    private static Button button_conduct1,button_sdate,button_stime,button_edate,button_etime;
    static final int DIALOG_ID=0,TIME_ID=1;
    int hour_x,minute_x,hour_x1,minute_x1;
    EditText sdate,edate,stime,etime,ename,edescrp,evenue;
    String upload_url;
    private DatePickerDialog.OnDateSetListener mDateSetListener,m1DateSetListener;


    private Button buttonChoose,buttonUpload;
    private ImageView imageView;
    private EditText editText;

    private static final int STORAGE_PERMISSION_CODE=2342;
    private static final int PICK_IMAGE_REQUEST=22;
    private Uri filepath;
    private Bitmap bitmap;
    private static final String UPLOAD_URL="http://192.168.43.206/eventbuzzphp/upload.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_conduct);
        sdate=(EditText) findViewById(R.id.sdatetxt2);
        edate=(EditText) findViewById(R.id.enddtxt);
        stime=(EditText) findViewById(R.id.stimetxt2);
        etime=(EditText) findViewById(R.id.etimetxt);
        ename=(EditText) findViewById(R.id.nametxt);
        edescrp=(EditText) findViewById(R.id.descrtxt);
        evenue=(EditText) findViewById(R.id.editText);
        editText=(EditText)findViewById(R.id.editTextName);
        OnClickButtonListener();
        requestStoragePermission();

    }
    private void requestStoragePermission(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == STORAGE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission granted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Permission not granted",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void showFileChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data !=null &&data.getData()!=null){
            filepath=data.getData();
            /*try{
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageView.setImageBitmap(bitmap);
            }catch (IOException e){

            }*/
        }
    }

    private String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    private void uploadImage(){
        String name=editText.getText().toString().trim();
        String path=getPath(filepath);
        try{
            String uploadid=UUID.randomUUID().toString();
            new MultipartUploadRequest(this,uploadid,UPLOAD_URL)
            .addFileToUpload(path,"image")
            .addParameter("name",name)
            .setNotificationConfig(new UploadNotificationConfig())
            .setMaxRetries(2)
            .startUpload();
            upload_url=uploadid;
        }catch(Exception e){

        }
    }
    public void OnClickButtonListener(){
        button_stime=(Button) findViewById(R.id.stime2);
        button_etime=(Button) findViewById(R.id.etime2);
        button_edate=(Button) findViewById(R.id.edate2);
        button_sdate=(Button) findViewById(R.id.sdate2);
        button_conduct1=(Button) findViewById(R.id.sconduct2);

        buttonUpload=(Button) findViewById(R.id.buttonUpload);
        buttonChoose=(Button)findViewById(R.id.buttonChoose);
        imageView=(ImageView)findViewById(R.id.imageView);

        buttonChoose.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        showFileChooser();
                    }
                }
        );

        buttonUpload.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                       uploadImage();
                    }
                }
        );
        button_conduct1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        if(onCond(view)) {

                        }
                    }
                }

        );
        button_edate.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {

                        Calendar cal=Calendar.getInstance();
                        int year=cal.get(Calendar.YEAR);
                        int month=cal.get(Calendar.MONTH);
                        int day=cal.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog dialog =new DatePickerDialog(student_conduct.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,m1DateSetListener,year,month,day
                        );
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();
                    }
                }
        );


        mDateSetListener=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d("hiii","onstartdateSet: mm/dd/yyyy: "+month +" / "+day+" / "+year);
                String date=year+"-"+month+"-"+day;
                sdate.setText(date);
            }
        };
        button_etime.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        showDialog(DIALOG_ID);
                    }

                }

        );
        button_sdate.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {

                        Calendar cal=Calendar.getInstance();
                        int year=cal.get(Calendar.YEAR);
                        int month=cal.get(Calendar.MONTH);
                        int day=cal.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog dialog =new DatePickerDialog(student_conduct.this,
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day
                        );
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();
                    }
                }
        );
        m1DateSetListener=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d("hiii","onenddateSet: mm/dd/yyyy: "+month +" / "+day+" / "+year);
                String date=year+"-"+month+"-"+day;
                edate.setText(date);
            }
        };
        button_stime.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        showDialog(TIME_ID);
                    }

                }

        );
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DIALOG_ID)
            return new TimePickerDialog(student_conduct.this,kTimePickerListener,hour_x,minute_x,false);
        if(id==TIME_ID)
            return new TimePickerDialog(student_conduct.this,k1TimePickerListener,hour_x,minute_x,false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener k1TimePickerListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x = hourOfDay;
            minute_x = minute;
            String time=hourOfDay+":"+minute+":"+"00";
            Log.d("starttime",time);
            stime.setText(time);
        }

    };
    protected TimePickerDialog.OnTimeSetListener kTimePickerListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x1 = hourOfDay;
            minute_x1 = minute;
            String time=hourOfDay+":"+minute+":"+"00";
            Log.d("endtime",time);
            etime.setText(time);
        }

    };
    public boolean onCond(View view ) {
        String str_empname = ename.getText().toString();
        String str_descr = edescrp.getText().toString();
        String str_sdate = sdate.getText().toString();
        String str_stime = stime.getText().toString();
        String str_edate = edate.getText().toString();
        String str_etime = etime.getText().toString();
        String str_venue = evenue.getText().toString();
        String str_imagename = evenue.getText().toString();

        String type = "student_conduct";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,str_empname,str_descr,str_venue,str_sdate,str_stime,str_edate,str_etime);
        // if(backgroundWorker.val==true)
        return true;
        //return false;
    }

}
