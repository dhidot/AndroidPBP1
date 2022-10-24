package com.pbp.senddatapbp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText nameText;
    EditText placeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.buttonId);
        nameText = findViewById(R.id.nameId);
        placeText = findViewById(R.id.placeId);

        //add on click listener to button
        sendButton.setOnClickListener(v -> {
            //get text from edit text
            String str1 = nameText.getText().toString();
            String str2 = placeText.getText().toString();

            //create intent
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            //put text in intent
            intent.putExtra("msgKey", str1);
            intent.putExtra("msgKey1", str2);

            //start activity
            startActivity(intent);
        });
    }
}