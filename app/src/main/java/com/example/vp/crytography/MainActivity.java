package com.example.vp.crytography;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText message = (EditText)findViewById(R.id.message);
        final String input = message.getText().toString();
        EditText vigenereKey = (EditText)findViewById(R.id.key);
        final String key = vigenereKey.getText().toString();
        EditText caesarShift = (EditText)findViewById(R.id.shift);
       // final int shift = (int)(caesarShift.getText().toString());
    }







}
