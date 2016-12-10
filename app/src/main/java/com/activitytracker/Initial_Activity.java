package com.activitytracker;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.activitytracker.model.Container;

public class Initial_Activity extends Activity {
    TextView nameTv, height, weight, dob;
    Container con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_);
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameTv = (TextView) findViewById(R.id.name);
        height = (TextView) findViewById(R.id.height);
        weight = (TextView) findViewById(R.id.weight);
        dob = (TextView) findViewById(R.id.dob);
    }

    public void conti(View view)
    {
        con=Container.getinstane();
        con.height=height.getText().toString();
        con.weight=weight.getText().toString();
        Log.d("a",nameTv.getText().toString());
        Log.d("b",height.getText().toString());
        Log.d("c",weight.getText().toString());
        Log.d("d",dob.getText().toString());

        Intent i = new Intent(this, Med_Data.class);
        startActivity(i);
    }
}
