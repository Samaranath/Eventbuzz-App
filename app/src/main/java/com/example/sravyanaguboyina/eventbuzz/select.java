package com.example.sravyanaguboyina.eventbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select extends AppCompatActivity {
       private static Button button_stud,button_prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        OnClickButtonListener();
    }

    private void OnClickButtonListener() {
        button_prof = (Button) findViewById(R.id.staffsign);
        button_prof.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.emp_signup");
                        startActivity(intent);
                    }
                }
        );
        button_stud = (Button) findViewById(R.id.stusign);
        button_stud.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.signup");
                        startActivity(intent);
                    }
                }
        );
    }

}
