package com.example.vp.crytography;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button encrypt;
    Button decrypt;
    TextView encryptedTV;
    TextView decryptedTV;
    boolean vigenere = false;
    boolean caesar = false;
    boolean scytale = false;
    String input = "";
    int shift;
    int rows;
    String key = "";
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText message = (EditText) findViewById(R.id.message);
        input = message.getText().toString();
        encrypt = (Button) this.findViewById(R.id.encrypt);
        decrypt = (Button) this.findViewById(R.id.decrypt);
        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);

    }

    public void onRadioButtonClicked (View v){
        boolean checked = ((RadioButton) v).isChecked();


        switch (v.getId()) {
            case R.id.scytale:
                if (checked) {
                    scytale = true;

                } else {
                    scytale = false;
                }
                break;

            case R.id.vigenere:
                if (checked) {
                    vigenere = true;
                } else {
                    vigenere = false;
                }
                break;

            case R.id.caesar:
                if (checked) {
                    caesar = true;
                } else {
                    caesar = false;
                }
                break;
        }

    }

    @Override
    public void onClick(View v) {
        if (v.equals(encrypt)) {
            if(caesar) {
                EditText eShift = (EditText)findViewById(R.id.shift);
                shift = Integer.parseInt(eShift.getText().toString());
                answer = caesarEncrypt(input, shift);
                encryptedTV.setText("Encryped: " + answer);
            }
        }

    }


    public String caesarEncrypt(String input, int shift){
        String output = "";

        return input;
    }




}
