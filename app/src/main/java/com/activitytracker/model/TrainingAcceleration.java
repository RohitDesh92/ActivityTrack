package com.activitytracker.model;

/**
 * Created by aksha on 27-04-2016.
 */
public class TrainingAcceleration {
    private String userID;
    private String activity;
    private Acceleration acceleration;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "TrainingAcceleration{" +
                "userID='" + userID + '\'' +
                ", activity='" + activity + '\'' +
                ", acceleration=" + acceleration +
                '}';
    }
}
