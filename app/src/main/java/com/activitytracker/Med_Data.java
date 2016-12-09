package com.activitytracker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Med_Data extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med__data);
    }

    public void register(View v)
    {
      Intent i = new Intent(this, MainActivity.class);
      startActivity(i);
    }

}
