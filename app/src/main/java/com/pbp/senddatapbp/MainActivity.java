package com.pbp.senddatapbp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.content.Intent;

import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button sendButton;
    EditText nameText;
    EditText placeText;
    EditText birthText;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.buttonId);
        nameText = findViewById(R.id.nameId);
        placeText = findViewById(R.id.placeId);
        birthText = findViewById(R.id.birthId);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        birthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,
                        year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                birthText.setText(date);
            }
        };


        //add on click listener to button
        sendButton.setOnClickListener(v -> {
            //get text from edit text
            String str1 = nameText.getText().toString();
            String str2 = placeText.getText().toString();
            String str3 = birthText.getText().toString();

            //create intent
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            //put text in intent
            intent.putExtra("msgKey", str1);
            intent.putExtra("msgKey1", str2);
            intent.putExtra("msgKey2", str3);

            //start activity
            startActivity(intent);
        });
    }
}