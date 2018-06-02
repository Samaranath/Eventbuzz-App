package com.example.sravyanaguboyina.eventbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class emp_signup extends AppCompatActivity {

    Spinner spinners,spinnerb;
    ArrayAdapter<CharSequence> adapters,adapterb;
    Button button_reg;
    String str_pos;
    String str_dpt;
    EditText usernameet, passwordet,emailet,phnnoet,empnameet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_signup);
        spinners= (Spinner) findViewById(R.id.pos);
        spinnerb= (Spinner) findViewById(R.id.dptt);
        adapters=ArrayAdapter.createFromResource(this,R.array.positions,android.R.layout.simple_spinner_item);
        adapterb=ArrayAdapter.createFromResource(this,R.array.branches,android.R.layout.simple_spinner_item);
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners.setAdapter(adapters);
        spinnerb.setAdapter(adapterb);
        spinners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_pos=spinners.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_dpt=spinnerb.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        usernameet = (EditText)findViewById(R.id.eusertxt);
        passwordet =  (EditText)findViewById(R.id.descrtxt1);
        emailet= (EditText)findViewById(R.id.sdatetxt);
        phnnoet= (EditText)findViewById(R.id.stimetxt);
        empnameet=(EditText)findViewById(R.id.emp_nametxt);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_reg = (Button) findViewById(R.id.sconduct);
        button_reg.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                       if( onReg(view))
                       {
                           Intent intent =new Intent(emp_signup.this,MainActivity.class);
                           startActivity(intent);
                       }

                    }
                }
        );

    }
    public boolean onReg(View view ){
        String str_uname = usernameet.getText().toString();
        String str_pword = passwordet.getText().toString();
        String str_email = emailet.getText().toString();
        String str_phnno = phnnoet.getText().toString();
        String str_empname= empnameet.getText().toString();

        String type = "emp_register";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,str_uname,str_pword,str_empname,str_email,str_phnno,str_pos,str_dpt);
       return true;
    }
}
