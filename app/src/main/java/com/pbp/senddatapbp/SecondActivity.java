
package com.pbp.senddatapbp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        textView1 = findViewById(R.id.receiver1);
        textView2 = findViewById(R.id.receiver2);
        textView3 = findViewById(R.id.receiver3);

        //get intent
        Intent intent = getIntent();

        //get data from intent
        String str1 = intent.getStringExtra("msgKey");
        String str2 = intent.getStringExtra("msgKey1");
        String str3 = intent.getStringExtra("msgKey2");

        //set text to text view
        textView1.setText(str1);
        textView2.setText(str2);
        textView3.setText(str3);
    }
}