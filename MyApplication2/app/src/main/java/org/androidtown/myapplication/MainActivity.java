package org.androidtown.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set for name, age and button
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.editText1);
        Age = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            //if person click then, getting a 2 text
            public void onClick(View view) {
                String UserName = Name.getText().toString();
                String UserAge = Age.getText().toString();
                //making vessel with input
                Intent intent = new Intent (getApplicationContext(), newActivity.class);
                //send message(name and age) to newActivity
                intent.putExtra("loginName", UserName);
                intent.putExtra("loginAge", UserAge);
                startActivity(intent);
            }
        });
    }
}

