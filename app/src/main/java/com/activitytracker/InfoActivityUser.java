package com.activitytracker;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.activitytracker.model.Container;

public class InfoActivityUser extends Activity {

    TextView bmiTV;
    TextView bmiResult;

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



        Log.d("dd","OnResume()");
        /*height=c.getHeight();
        weight=c.getWeight();

      if(c.getHeight()!= null || c.getWeight()!=null ) {
          Log.d("pp", height);
          Log.d("cc", weight);
        }
      else
      {
          Log.d("p","Null Value set" );

      }*/


    }


}
