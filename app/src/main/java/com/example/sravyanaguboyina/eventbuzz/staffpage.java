package com.example.sravyanaguboyina.eventbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class staffpage extends AppCompatActivity {
    private static Button button_conduct,button_view,button_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffpage);
        OnClickButtonListener();
    }

    private void OnClickButtonListener() {
        button_conduct = (Button) findViewById(R.id.staffe1);
        button_conduct.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.staff_conduct");
                        startActivity(intent);
                    }
                }
        );
        button_view = (Button) findViewById(R.id.stue1);
        button_view.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.staffview");
                        startActivity(intent);
                    }
                }
        );
        button_logout = (Button) findViewById(R.id.logouts);
        button_logout.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent i = new Intent(staffpage.this, MainActivity.class);
                        //i.putExtra("reg","20155114");
                        startActivity(i);
                    }
                }
        );
    }
}
