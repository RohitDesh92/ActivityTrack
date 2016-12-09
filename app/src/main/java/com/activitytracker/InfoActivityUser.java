package com.activitytracker;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.activitytracker.model.Container;

import static com.activitytracker.Med_Data.str;

public class InfoActivityUser extends Activity {

    TextView bmiTV;
    TextView bmiResult;
    EditText recTV;

    String height;
    String weight;
    Container con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_user);
        con=Container.getinstane();
        bmiTV = (TextView) findViewById(R.id.ht);
        bmiResult = (TextView) findViewById(R.id.wt);
        recTV = (EditText) findViewById(R.id.rec);

        Log.d("dd","OnCreate");

    }

    @Override
    protected void onResume() {
        super.onResume();
        String ht=con.height;
        String wt=con.weight;
        System.out.println(""+ht);
        System.out.println(""+wt);

        Float htt = Float.valueOf(ht);
        Float wtt = Float.valueOf(wt);

        Float bmi;
        bmi = (wtt/(htt*htt));

        bmiTV.setText(bmi.toString());

        if(bmi < 19)   //Underweight
        {
            bmiResult.setText("Underweight");
        }
        else if(bmi >= 19 && bmi <= 25)  // Normal Weight
        {
            bmiResult.setText("Normal Weight");

        }
        else if(bmi > 25 && bmi <= 30 ) // Overweight
        {
            bmiResult.setText("Overweight");
        }
        else if(bmi > 30 && bmi <= 35 ) // Obese class 1 (Moderately Obese)
        {
            bmiResult.setText("Obese class 1 (Moderately Obese)");
        }
        else if(bmi > 35 && bmi <= 40 ) // Obese class 2 (Severely Obese)
        {
            bmiResult.setText("Obese class 2 (Severely Obese)");
        }
        else // Obese class 3 (very Severely Obese)
        {
            bmiResult.setText("Obese class 3 (very Severely Obese)");
        }

        String redval = str ;


        Log.d("dd","OnResume()");
        Log.d("d1",redval);
        int dist = 15;

        switch(redval)
           {
               case "Joint Pain" :
                                        if(dist >= 15)
                                        recTV.setText("You are doing well as you are walking your goal  ");
                                        else
                                            recTV.setText("You need to walk more to achieve your goal");
                                        break;

               case "Blood Pressure" :  if(dist >= 15)
                                        recTV.setText("You are doing well as you are walking your goal  ");
                                        else
                                        recTV.setText("You need to walk more to achieve your goal");
                                        break;

               case "Diabetes" :        if(dist >= 15)
                                        recTV.setText("You are doing well as you are walking your goal  ");
                                        else
                                        recTV.setText("You need to walk more to achieve your goal");
                                        break;

               case "Sleep Disorder" :  if(dist >= 15)
                                        recTV.setText("You are doing well as you are walking your goal  ");
                                        else
                                        recTV.setText("You need to walk more to achieve your goal");
                                        break;

               case "None":             if(dist >= 15)
                                        recTV.setText("You are doing well as you are walking your goal  ");
                                        else
                                        recTV.setText("You need to walk more to achieve your goal");
                                        break;
           }



    }


}
