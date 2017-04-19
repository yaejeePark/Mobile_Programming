package org.androidtown.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        Intent myCallerIntent2 = getIntent();

        Bundle myBundle = myCallerIntent2.getExtras();
        String name = myBundle.getString("name");
        textView13.setText(name);
        String sex = myBundle.getString("sex");
        textView5.setText(sex);
        String sns = myBundle.getString("sns");
        textView3.setText(sns);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}



