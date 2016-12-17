package com.activitytracker.model;

public class TrainingAcceleration {
    private String userID;
    private String activity;
    private Acceleration acceleration;


    @Override
    public String toString() {
        return "TrainingAcceleration{" +
                "userID='" + userID + '\'' +
                ", activity='" + activity + '\'' +
                ", acceleration=" + acceleration +
                '}';
    }
}