package com.example.vp.crytography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button[] clickme = new Button[1];
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickme[0] =(Button)this.findViewById(R.id.button1);

    }

    @Override
    public void onClick(View v){
        Button b = (Button)v;
        //input = ((EditText)(this.findViewById(R.id.email_address))).getText();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }




}
