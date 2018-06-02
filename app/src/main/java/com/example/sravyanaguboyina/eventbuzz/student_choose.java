package com.example.sravyanaguboyina.eventbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class student_choose extends AppCompatActivity {
    private static Button button_create,button_view,button_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_choose);
        OnClickButtonListener();
    }
    private void OnClickButtonListener() {
        button_create = (Button) findViewById(R.id.stu_conduct);
        button_create.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.student_conduct");
                        startActivity(intent);
                    }
                }
        );
        button_view = (Button) findViewById(R.id.stu_view);
        button_view.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.staffview");
                        startActivity(intent);
                    }
                }
        );
        button_view=(Button) findViewById(R.id.staff_view);
        button_view.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.student_view");
                        startActivity(intent);
                    }
                }
        );
        button_logout=(Button) findViewById(R.id.logout);
        button_logout.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Intent i = new Intent(student_choose.this, MainActivity.class);
                        //i.putExtra("reg","20155114");
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id=item.getItemId();
        switch(item.getItemId()){
            case R.id.menulogout:
                Intent intent =new Intent("com.example.sravyanaguboyina.eventbuzz.MainActivity");
                startActivity(intent);
                break;
        }
        return true;
    }
}
