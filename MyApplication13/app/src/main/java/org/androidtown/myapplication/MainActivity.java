package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity{
    String sns=null;
    String e_mail=null;
    String male=null;
    String female=null;
    String edit_text=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox check1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox check2 = (CheckBox) findViewById(R.id.checkBox2);
        RadioGroup rg = (RadioGroup)findViewById(R.id.radio0);
        Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                if(checkedId == R.id.radioButton){
                    male = "남";
                }
                else{
                    female = "여";
                }
            }
        });

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle myBundle = new Bundle();
                if(male==null) {
                    myBundle.putString("sex", female);
                }
                else
                    myBundle.putString("sex", male);
                if(check1.isChecked()==true) {
                    myBundle.putString("sns", "sns");
                }
                else
                    myBundle.putString("sns", "e-mail");
                myBundle.putString("name", editText.getText().toString());
                intent.putExtras(myBundle);
                startActivity(intent);
            }
        });
    }
}