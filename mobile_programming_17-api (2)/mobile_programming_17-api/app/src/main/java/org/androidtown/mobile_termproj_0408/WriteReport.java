package org.androidtown.mobile_termproj_0408;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class WriteReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_report);

        Intent i=getIntent();

        EditText et=(EditText)findViewById(R.id.report);
        String reportTxt= et.getText().toString();


        //db에 저장!
    }
}