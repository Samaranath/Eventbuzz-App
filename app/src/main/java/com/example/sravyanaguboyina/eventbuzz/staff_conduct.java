package com.example.sravyanaguboyina.eventbuzz;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class staff_conduct extends AppCompatActivity {
    private static  Button button_conduct,button_date,button_time;
    static final int DIALOG_ID=0;
    int hour_x,minute_x;
    Spinner spinnerse,spinnerbr;
    ArrayAdapter<CharSequence> adapterse,adapterbr;

       private DatePickerDialog.OnDateSetListener mDateSetListener;
    String str_sem;
    String str_br;
    EditText empidet, descret,dateet,timeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_conduct);

        spinnerse= (Spinner) findViewById(R.id.semm1);
        spinnerbr= (Spinner) findViewById(R.id.dpt1);
        adapterse=ArrayAdapter.createFromResource(this,R.array.sems,android.R.layout.simple_spinner_item);
        adapterbr=ArrayAdapter.createFromResource(this,R.array.branches,android.R.layout.simple_spinner_item);
        adapterse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterbr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerse.setAdapter(adapterse);
        spinnerbr.setAdapter(adapterbr);
        spinnerse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_sem=spinnerse.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerbr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_br=spinnerbr.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        empidet = (EditText)findViewById(R.id.nametxt1);
        descret =  (EditText)findViewById(R.id.descrtxt3);
        dateet= (EditText)findViewById(R.id.sdatetxt3);
        timeet= (EditText)findViewById(R.id.stimetxt3);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_conduct = (Button) findViewById(R.id.sconduct3);
        button_date=(Button)findViewById(R.id.sdate1);
        button_time=(Button)findViewById(R.id.stime1);
        button_conduct.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        if(onCond(view)) {

                        }
                    }
                }

        );
        button_date.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {

                      Calendar cal=Calendar.getInstance();
                        int year=cal.get(Calendar.YEAR);
                        int month=cal.get(Calendar.MONTH);
                        int day=cal.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog dialog =new DatePickerDialog(staff_conduct.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year,month,day
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
                Log.d("hiii","ondateSet: mm/dd/yyyy: "+month +" / "+day+" / "+year);
                String date=year+"-"+month+"-"+day;
                dateet.setText(date);
            }
        };
        button_time.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                       showDialog(DIALOG_ID);
                    }

                }

        );
}
  @Override
  protected Dialog onCreateDialog(int id){
      if(id==DIALOG_ID)
          return new TimePickerDialog(staff_conduct.this,kTimePickerListener,hour_x,minute_x,false);
      return null;
  }

  protected TimePickerDialog.OnTimeSetListener kTimePickerListener = new TimePickerDialog.OnTimeSetListener(){
      @Override
      public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
          hour_x = hourOfDay;
          minute_x = minute;
          String time=hourOfDay+":"+minute+":"+"00";
          Log.d("time",time);
          timeet.setText(time);
      }

  };

    public boolean onCond(View view ) {
        String str_empid = empidet.getText().toString();
        String str_descr = descret.getText().toString();
        String str_date = dateet.getText().toString();
        String str_time = timeet.getText().toString();


        String type = "conduct";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,str_empid,str_descr,str_date,str_time,str_sem,str_br);
       // if(backgroundWorker.val==true)
            return true;
        //return false;
    }
}
