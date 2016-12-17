package com.activitytracker.model;

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
