package com.activitytracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.activitytracker.R.id.radio;
import static com.activitytracker.R.id.radioButton;

public class Med_Data extends Activity {

    RadioGroup rg;
    RadioButton radioButton;
    String radiovalue;
    Button btnDisplay;
    public static String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med__data);


    }

   /* public void addListenerOnButton() {
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        btnDisplay = (Button) findViewById(R.id.button2);
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int value = rg.getCheckedRadioButtonId();

                System.out.println(String.valueOf(value));

                radioButton = (RadioButton) findViewById(value);
                radiovalue = radioButton.getText().toString();
                str = radiovalue;
               System.out.println(radiovalue);

            }

        });

    }*/


   public void register(View v)
    {
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        btnDisplay = (Button) findViewById(R.id.button2);
        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int value = rg.getCheckedRadioButtonId();

                System.out.println(String.valueOf(value));

                radioButton = (RadioButton) findViewById(value);
                radiovalue = radioButton.getText().toString();
                str = radiovalue;
                System.out.println(radiovalue);
                Intent i = new Intent(Med_Data.this, MainActivity.class);
                startActivity(i);
                Log.d("we",str);
            }


        });

     // Intent i = new Intent(this, MainActivity.class);
      //i.putExtra("rad",str);
       //  Log.d("we",str);

    }

}
