package com.activitytracker.model;

/**
 * Created by Rohit on 12/6/16.
 */

public class Container {

    private static final Container c = new Container();
    public String height = "";
    public String weight = "";

    private Container(){
    }

    public static Container getinstane(){
        return c;
    }
}
