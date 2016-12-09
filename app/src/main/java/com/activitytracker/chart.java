package com.activitytracker;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import org.json.JSONObject;
import com.android.volley.toolbox.JsonObjectRequest;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.formatter.PercentFormatter;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import android.widget.TextView;
import com.android.volley.toolbox.StringRequest;
import android.util.Log;
import com.android.volley.VolleyError;

public class chart extends Activity {
    // private FrameLayout chartLayout;
    private PieChart mChart;

    private float[] yAxis = {3, 5, 8, 9, 12};
    private String[] xAxis = {"Walking", "Standing", "climbing", "Running", "sleeping"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://httpbin.org/get?param1=hello";

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);

        mChart = (PieChart) findViewById(R.id.chart);

        addData();

        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.ABOVE_CHART_LEFT);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(7f);
        l.setYOffset(4f);

    }

    private void addData() {
        ArrayList<Entry> yValue = new ArrayList<Entry>();

        for (int i = 0; i < yAxis.length; i++) {
            yValue.add(new Entry(yAxis[i], i));
        }

        ArrayList<String> xValue = new ArrayList<String>();

        for (int i = 0; i < xAxis.length; i++)
            xValue.add(xAxis[i]);

        PieDataSet dataSet = new PieDataSet(yValue, "%");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);


        PieData data = new PieData(xValue, dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS); //
        mChart.setDescription("Activity Distrubution");
        mChart.setDescriptionTextSize(25f);
        mChart.setData(data);
        mChart.setUsePercentValues(true);
        mChart.animateY(5000);
    }

}
