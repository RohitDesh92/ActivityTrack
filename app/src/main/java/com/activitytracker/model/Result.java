package com.activitytracker.model;

/**
 * Created by Rohit on 12/9/16.
 */

public class Result {

    private String activity;
    private long timestamp;

    public Result(String activity, long timestamp) {
        this.activity = activity;
        this.timestamp = timestamp;
    }

    public String getActivity() {
        return activity;
    }


    public long getTimestamp() {
        return timestamp;
    }

}
