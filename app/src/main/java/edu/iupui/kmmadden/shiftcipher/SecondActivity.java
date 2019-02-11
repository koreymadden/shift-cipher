package edu.iupui.kmmadden.shiftcipher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    static String message;
    static int userShift;

    static String userShiftString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get the intent that started this activity and extract the string
        //Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        message = bundle.getString("MESSAGE").toLowerCase();
        userShiftString = bundle.getString("SHIFTVALUE");
        userShift = Integer.valueOf(userShiftString);

        TextView txtView = (TextView) findViewById(R.id.textOutput);

        txtView.setText(message);

    }





    //static String message = "korey madden message";
    static String newMessage = "";
    //static int userShift = 2;

    static char[] normalArray = new char[] { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', ' ' };
    static String normalArrayString = new String(normalArray);

    static char[] newArray = new char[27];
    static String newArrayString = arrayShift(userShift);

    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println(arrayShift(userShift));
        System.out.println(toIndex());

    }

    public static String arrayShift(int shift) {

        newArray[26] = ' ';
        System.out.println(Integer.toString(userShift + 1) + " pizza!");
        System.out.println(message + " pizza2!");


        for (int i = 0; i < 26; i++) {

            int newPosition = i + shift;

            if (newPosition > 25) {
                newPosition = newPosition - 26;
                newArray[newPosition] = normalArray[i];
                System.out.println(Integer.toString(newPosition) + " - newPosition / index");
                System.out.println((normalArray[i]) + " - normalArray Content");
                System.out.println((newArray[newPosition]) + " - newArray Content");
                System.out.println(Integer.toString(newPosition) + " - 'if'");
            } else {
                newArray[newPosition] = normalArray[i];
                System.out.println(Integer.toString(newPosition) + " - newPosition / index");
                System.out.println((normalArray[i]) + " - normalArray Content");
                System.out.println((newArray[newPosition]) + " - newArray Content");
                System.out.println(Integer.toString(newPosition) + " - 'else'");
            }

        }

        System.out.println("Stripe");


        String stringOutput = new String(newArray);

        return stringOutput;

    };

    public static String toIndex() {
        for (int i = 0; i < message.length(); i++) {

            char letter = message.charAt(i);
            System.out.println(letter + " - Message Letter");

            int normalIndex = normalArrayString.indexOf(letter);
            System.out.println(Integer.toString(normalIndex) + " - Letter Index");

            int newLetterIndex = new String(newArrayString).indexOf(letter);
            System.out.println(Integer.toString(newLetterIndex) + " - New Letter Index");

            char newLetter =  normalArray[newLetterIndex];
            System.out.println(normalArray[newLetterIndex] + " - Cipher Letter");

            newMessage +=  newLetter;

            System.out.println(" ");

        }

        System.out.println(newMessage + " - Post Shift");
        return newMessage;
    }





}
