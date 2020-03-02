package com.example.vp.crytography;

import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText code;
    String input = "";
    EditText num;
    int inputNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addKeyListener();

    }

    public void addKeyListener(){
        code = (EditText) findViewById(R.id.email_address);
        code.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    input = code.getText().toString();

                    return true;
                }

                return false;
            }
        });

        num = (EditText) findViewById(R.id.number);
        num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                    //inputNum = Integer.parseInt(num.getText());
                }

                return false;
            }
        });

    }

//    public String encryption(String input, int numRows){
//
//    }




}
