package com.activitytracker.model;

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
