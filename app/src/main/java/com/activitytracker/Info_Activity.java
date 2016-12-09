package com.activitytracker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.activitytracker.view.ExpandableList;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.activitytracker.model.Container;


public class Info_Activity extends Activity  {

    TextView latTV;
    TextView lanTV;
    private LocationManager loc;
    private Location location;



    //Container c = new Container();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);




    }




    /*
    public void onLocationChanged(Location location) {

        Log.d("aa","onLocationChanged()");
        double lat = location.getLatitude();
        double lang = location.getLongitude();
        String lati = String.valueOf(lat);
        String lan = String.valueOf(lang);

       latTV.setText(lati);
       lanTV.setText(lan);

        Log.d("ss",lati);
        Log.d("pp",lan);
        System.out.print("Latitude Value"+lati);
        System.out.print("Longitude Value"+lan);
    } */





}
