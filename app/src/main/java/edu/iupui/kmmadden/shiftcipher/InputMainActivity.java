package edu.iupui.kmmadden.shiftcipher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputMainActivity extends AppCompatActivity {

    EditText mMessage;
    EditText mShift;
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_main);

        // WIRE UP OUR INTERACTIVE WIDGETS (CONTROLS)

        mMessage = (EditText) findViewById(R.id.userMessage);
        mShift = (EditText) findViewById(R.id.userShift);
        mSubmit = (Button) findViewById(R.id.btnSubmit);

        // SET UP OUR ONCLICKLISTENER
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // LOAD 2ND ACTIVITY
                encryptMessage();

            }
        });

    } // END OF THE onCreate()

    public void encryptMessage() {
        //Toast.makeText(this, "Loading Second activity!", Toast.LENGTH_SHORT).show();

        // CREATE INTENT (address envelope)
        Intent encryptIntent = new Intent(this, SecondActivity.class);

        // GET MESSAGE FROM USER (write letter)
        String inputMessage = mMessage.getText().toString();

        // ADD EXTRA CONTAINING MESSAGE TO THE INTENT (put the letter in the envelope)
        encryptIntent.putExtra("MESSAGE", inputMessage);

        startActivity(encryptIntent);

    }

} // END OF THE InputActivity CLASS
