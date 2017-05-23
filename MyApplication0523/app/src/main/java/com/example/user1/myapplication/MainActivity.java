package com.example.user1.myapplication;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.txtData);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() { // 이미지 버튼 이벤트 정의
                                       @Override
                                       public void onClick(View v) {
                                           b1(1);
                                       }
                                   }
        );
        button2.setOnClickListener(new View.OnClickListener() { // 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) {
                b2(2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) {
                b3(3);
            }
            });

        button4.setOnClickListener(new View.OnClickListener() { // 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) {
                b4(1);
            }
        });
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            button1.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }


    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


    public void b1(int i){
        Toast.makeText(getApplicationContext(),"1이 눌렸습니다.",Toast.LENGTH_LONG).show();
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        editText.setText("");
    }
    public void b2(int i){
        Toast.makeText(getApplicationContext(),"2가 눌렸습니다.",Toast.LENGTH_LONG).show();
        editText.setText(null);
        editText.setHint("Enter some lines of data here...");
    }
    public void b3(int i){
        Toast.makeText(getApplicationContext(),"3이 눌렸습니다.",Toast.LENGTH_LONG).show();
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        editText.setText(myData);
    }
    public void b4(int i){
        Toast.makeText(getApplicationContext(),"4가 눌렸습니다.",Toast.LENGTH_LONG).show();
        finish();
    }


}