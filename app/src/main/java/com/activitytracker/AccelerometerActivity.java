package com.activitytracker;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.activitytracker.CassandraRestApi;
import com.activitytracker.model.Acceleration;
import com.activitytracker.model.Result;

import java.util.Date;

import retrofit.RestAdapter;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private String restURL = "http://104.154.252.38:8080/activity";
    private TextView acceleration;
    private Button myStartButton;
    private Button myStopButton;

    private CassandraRestApi cassandraRestApi;

    private SensorManager sm;
    private Sensor accelerometer;
    private PowerManager.WakeLock wl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        acceleration = (TextView) findViewById(R.id.acceleration);

        //Init accelerometer sensor
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Tag");
        wl.acquire();

        initRestApi();
        initActionButtons();
    }
    public void onBackPressed() {
        startActivity(new Intent(AccelerometerActivity.this, MainActivity.class));
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        wl.release();
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accelerometer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Acceleration capturedAcceleration = getAccelerationFromSensor(event);
        updateTextView(capturedAcceleration);
        new SendAccelerationAsyncTask().execute(capturedAcceleration);
        new SendResult().execute(capturedAcceleration);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Do nothing
    }

    private void initRestApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(restURL)
                .build();

        cassandraRestApi = restAdapter.create(CassandraRestApi.class);
    }


    private void initActionButtons() {
        myStartButton = (Button) findViewById(R.id.button_start);
        myStopButton = (Button) findViewById(R.id.button_stop);

        myStartButton.setVisibility(View.VISIBLE);
        myStopButton.setVisibility(View.GONE);

        //Start button action on click
        myStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSensor();
                myStartButton.setVisibility(View.GONE);
                myStopButton.setVisibility(View.VISIBLE);
            }
        });

        //Stop button action on click
        myStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSensor();
                myStartButton.setVisibility(View.VISIBLE);
                myStopButton.setVisibility(View.GONE);
                finish();
            }
        });
    }

    private void startSensor() {
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stopSensor() {
        sm.unregisterListener(this);
    }


    private void updateTextView(Acceleration capturedAcceleration) {
        acceleration.setText("X:" + capturedAcceleration.getX() +
                "\nY:" + capturedAcceleration.getY() +
                "\nZ:" + capturedAcceleration.getZ() +
                "\nTimestamp:" + capturedAcceleration.getTimestamp());
    }

    private Acceleration getAccelerationFromSensor(SensorEvent event) {
        long timestamp = (new Date()).getTime() + (event.timestamp - System.nanoTime()) / 1000000L;
        return new Acceleration(event.values[0], event.values[1], event.values[2], timestamp);


    }


    private class SendAccelerationAsyncTask extends AsyncTask<Acceleration, Void, Void> {

        @Override
        protected Void doInBackground(Acceleration... params) {
            try {
                cassandraRestApi.sendAccelerationValues(params[0]);

            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class SendResult extends AsyncTask<Acceleration, Void, Void> {
        @Override
        protected Void doInBackground(Acceleration... accelerations) {
            Acceleration acceleration = accelerations[0];
            double x = acceleration.getX();
            double y = acceleration.getY();
            double z = acceleration.getZ() - SensorManager.GRAVITY_EARTH;

            double res  = (x * x + y * y + z * z+2*(x*y+x*z+z*y))
                    / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);

            if(res >= 20){
                Result result = new Result("Jogging",System.currentTimeMillis());
                try {
                    cassandraRestApi.sendpredictionValues(result);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
