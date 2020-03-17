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

        encrypt = (Button) this.findViewById(R.id.encrypt);
        decrypt = (Button) this.findViewById(R.id.decrypt);
        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
        encryptedTV = (TextView)this.findViewById(R.id.encrypted);
        decryptedTV = (TextView)this.findViewById(R.id.decrypted);

    }

    public void onRadioButtonClicked (View v){
        boolean checked = ((RadioButton) v).isChecked();


        switch (v.getId()) {
            case R.id.scytale:
                if (checked) {
                    scytale = true;
                    vigenere = false;
                    caesar = false;
                }
                break;

            case R.id.vigenere:
                if (checked) {
                    vigenere = true;
                    scytale = false;
                    caesar = false;
                }
                break;

            case R.id.caesar:
                if (checked) {
                    caesar = true;
                    vigenere =false;
                    scytale = false;
                }
                break;
        }

    }

    @Override
    public void onClick(View v) {
        if (v.equals(encrypt)) {
            if(caesar) {
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eShift = (EditText)findViewById(R.id.shift);
                shift = Integer.parseInt(eShift.getText().toString());
                answer = caesarEncrypt(input, shift);
                encryptedTV.setText("Encrypted: " + answer);
                decryptedTV.setText("Decrypted: " + input);
            }else if(vigenere){
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eKey = (EditText)findViewById(R.id.key);
                key = eKey.getText().toString();
                answer = vigenereEncrypt(input, key);
                encryptedTV.setText("Encrypted: " + answer);
                decryptedTV.setText("Decrypted: " + input);
            }else{
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eRows = (EditText)findViewById(R.id.rows);
                rows = Integer.parseInt(eRows.getText().toString());
                answer = skytaleEncrypt(input, rows);
                encryptedTV.setText("Encrypted: " + answer);
                decryptedTV.setText("Decrypted: " + input);
            }
        }else{
            if(caesar){
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eShift = (EditText)findViewById(R.id.shift);
                shift = Integer.parseInt(eShift.getText().toString());
                answer = caesarDecrypt(input, shift);
                decryptedTV.setText("Decrypted: " + answer);
                encryptedTV.setText("Encrypted: " + input);
            }else if(vigenere){
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eKey = (EditText)findViewById(R.id.key);
                key = eKey.getText().toString();
                answer = vigenereDecrypt(input, key);
                decryptedTV.setText("Decrypted: " + answer);
                encryptedTV.setText("Encrypted: " + input);
            }else{
                input = "";
                answer = "";
                EditText message = (EditText) findViewById(R.id.message);
                input = message.getText().toString();
                EditText eRows = (EditText)findViewById(R.id.rows);
                rows = Integer.parseInt(eRows.getText().toString());
                answer = skytaleDecrypt(input, rows);
                decryptedTV.setText("Decrypted: " + answer);
                encryptedTV.setText("Encrypted: " + input);
            }
        }

    }

    public String caesarEncrypt(String input, int shift)
    {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers

        while(shift > 26) {
            shift = shift - 26;
        }

        for(int i = 0; i <= input.length() - 1; i++)
        {
            if(input.charAt(i) + shift > 90)
            {

                output += (char)((input.charAt(i) + shift) - 26);

            }else
            {

                output += (char)(input.charAt(i)+shift);

            }
        }

        output = output.toUpperCase();
        return output;
    }

    public String vigenereEncrypt(String input, String key)
    {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers
        key = key.toUpperCase();
        int j = 0;

        for(int i = 0; i <= input.length() - 1; i++)
        {
            if(j == key.length())
            {
                j = 0;
            }

            if((input.charAt(i) + (key.charAt(j) - 65)) > 90){
                int num = (input.charAt(i) + (key.charAt(j) - 65) - 26);
                output += (char)(num);
            }else {

                output += (char)(input.charAt(i) + (key.charAt(j) - 65));
            }
            j++;

        }

        output = output.toUpperCase();
        return output;

    }

    public String skytaleEncrypt(String input, int numRows) {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers
        int numColumns;
        numColumns = Math.round((input.length()/numRows) + 1);
        int numFilled = numRows - ((numRows * numColumns) - input.length());
        int strI = 0;

        char[][] decodeCylinder = new char[numRows][numColumns];

        for(int i = 0; i < decodeCylinder.length; i++)
        {
            for (int j = 0; j < decodeCylinder[0].length; j++)
            {
                if(j == numColumns - 1 && numFilled <= 0 || strI >= input.length()) {
                    decodeCylinder[i][j] = '@';
                }else
                {
                    decodeCylinder[i][j] = input.charAt(strI);
                    strI++;
                }
            }
            numFilled--;
        }

        for (int i = 0; i < decodeCylinder[0].length; i++) {
            for (int j = 0; j < decodeCylinder.length; j++) {
                if(decodeCylinder[j][i] != '@') {
                    output += decodeCylinder[j][i];
                }
            }
        }

//		System.out.println(numColumns);
        output = output.toUpperCase();
        return output;
    }

    public String caesarDecrypt(String input, int shift)
    {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers

        while(shift > 26) {
            shift = shift - 26;
        }

        for(int i = 0; i <= input.length() - 1; i++)
        {
            if(input.charAt(i) - shift < 65)
            {

                output += (char)((input.charAt(i) - shift) + 26);

            }else
            {

                output += (char)(input.charAt(i) - shift);

            }
        }

        output = output.toUpperCase();
        return output;

    }

    public String vigenereDecrypt(String input, String key) {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers
        key = key.toUpperCase();
        int j = 0;

        for(int i = 0; i <= input.length() - 1; i++)
        {
            if(j == key.length())
            {
                j = 0;
            }

            if((input.charAt(i) - (key.charAt(j) - 65)) < 65){
                int num = (input.charAt(i) - (key.charAt(j) - 65) + 26);
                output += (char)(num);
            }else {

                output += (char)(input.charAt(i) - (key.charAt(j) - 65));
            }
            j++;

        }

        output = output.toUpperCase();
        return output;
    }

    public String skytaleDecrypt(String input, int numRows) {
        String output = "";
        input = input.toUpperCase();
        input = input.replaceAll("[^a-zA-Z0-9_-]", ""); //removes special characters
        input = input.replaceAll("\\s+", ""); //removes spaces
        input = input.replaceAll("[0-9]+", ""); //removes numbers
        int numColumns;
        numColumns = Math.round((input.length()/numRows) + 1);
        int numFilled = numRows - ((numRows * numColumns) - input.length());
        int strI = 0;

        String ps = "";

        for (int i = 0; i < numRows * numColumns; i++) {
            if(strI >= input.length()) {
                ps += '@';
            }else {
                ps += input.charAt(strI);
                strI++;
            }
        }

        strI = 0;

        char[][] decodeCylinder = new char[numRows][numColumns];

        for(int i = 0; i < decodeCylinder[0].length; i++)
        {
            for (int j = 0; j < decodeCylinder.length; j++)
            {
                decodeCylinder[j][i] = ps.charAt(strI);
                strI++;
            }

        }

        for (int i = 0; i < decodeCylinder.length; i++) {
            for (int j = 0; j < decodeCylinder[0].length; j++) {
                if(decodeCylinder[i][j] != '@') {
                    output += decodeCylinder[i][j];
                }
            }
        }

//		System.out.println(numColumns);
        output = output.toUpperCase();
        return output;
    }


}
