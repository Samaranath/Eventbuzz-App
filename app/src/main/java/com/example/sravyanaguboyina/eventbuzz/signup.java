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

public class signup extends AppCompatActivity {
    Spinner spinners,spinnerb;
    ArrayAdapter<CharSequence> adapters,adapterb;
    Button button_reg;
    String str_sem;
    String str_br;
    EditText usernameet, passwordet,emailet,phnnoet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        spinners= (Spinner) findViewById(R.id.semm);
        spinnerb= (Spinner) findViewById(R.id.dpt);
        adapters=ArrayAdapter.createFromResource(this,R.array.sems,android.R.layout.simple_spinner_item);
        adapterb=ArrayAdapter.createFromResource(this,R.array.branches,android.R.layout.simple_spinner_item);
        adapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners.setAdapter(adapters);
        spinnerb.setAdapter(adapterb);
        spinners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 str_sem=spinners.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_br=spinnerb.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        usernameet = (EditText)findViewById(R.id.usertxt);
        passwordet =  (EditText)findViewById(R.id.descrtxt2);
        emailet= (EditText)findViewById(R.id.sdatetxt1);
        phnnoet= (EditText)findViewById(R.id.stimetxt1);
        OnClickButtonListener();
    }
    public void OnClickButtonListener(){
        button_reg = (Button) findViewById(R.id.sconduct1);
        button_reg.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        if(onReg(view)) {
                            Intent intent = new Intent(signup.this, MainActivity.class);
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


        String type = "register";
        backgroundWorker backgroundWorker=new backgroundWorker(this);//creating an instance of backgroundworker class and pass context
        backgroundWorker.execute(type,str_uname,str_pword,str_email,str_phnno,str_sem,str_br);
        return  true;
    }
}
