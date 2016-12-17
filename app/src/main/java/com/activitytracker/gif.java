package com.activitytracker;

import android.os.Bundle;
import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import android.widget.TextView;
import com.android.volley.toolbox.StringRequest;
import android.util.Log;
import com.android.volley.VolleyError;

public class gif extends Activity {
    public static String type = "";
    TextView textViewInfo;
    GifView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        RequestQueue queue = Volley.newRequestQueue(this);

        final String url = "http://104.154.252.38:8080/activity/acceleration/prediction";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("Response is: " ,response);
                        type = response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("That didn't work!",error.toString());
            }
        });


        queue.add(stringRequest);
        gifView = (GifView) findViewById(R.id.gif_view);
        textViewInfo = (TextView) findViewById(R.id.textinfo);

    }
}
