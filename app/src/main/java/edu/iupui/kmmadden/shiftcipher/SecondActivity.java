package edu.iupui.kmmadden.shiftcipher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    static String message;
    static int userShift;
    static String userShiftString;
    static String newMessage = "";
    static char[] normalArray = new char[] { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', ' ' };
    static String normalArrayString = new String(normalArray);
    static char[] newArray = new char[27];
    static String newArrayString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getExtras();

        message = bundle.getString("MESSAGE").toLowerCase();
        userShiftString = bundle.getString("SHIFTVALUE");

        userShift = Integer.valueOf(userShiftString);

        newArrayString = arrayShift(userShift);
        String display = toIndex();

        TextView txtView = (TextView) findViewById(R.id.textOutput);
        TextView txtView2 = (TextView) findViewById(R.id.textOutput2);
        TextView txtView3 = (TextView) findViewById(R.id.textOutput3);

        txtView.setText("Original Message: " + message);
        txtView2.setText("Shift Value: " + userShiftString);
        txtView3.setText("Encrypted Message: " + display);

     }

    public String arrayShift(int shift) {

        newArray[26] = ' ';

        for (int i = 0; i < 26; i++) {

            int newPosition = i + shift;

            if (newPosition > 25) {
                newPosition = newPosition - 26;
                newArray[newPosition] = normalArray[i];
            } else {
                newArray[newPosition] = normalArray[i];
            }
        }
        String stringOutput = new String(newArray);
        return stringOutput;
    }

    public static String toIndex() {
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            int newLetterIndex = new String(newArrayString).indexOf(letter);
            char newLetter =  normalArray[newLetterIndex];
            newMessage +=  newLetter;
        }
        return newMessage;
    }

}
