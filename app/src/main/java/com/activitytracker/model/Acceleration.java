package com.activitytracker.model;

import android.support.v7.util.SortedList;

public class Acceleration extends SortedList.Callback<Acceleration> {

        private long timestamp;
        private double x;
        private double y;
        private double z;

        public Acceleration(float x_value, float y_value, float z_value, long timestamp) {
            x= new Double(""+x_value);
            y= new Double(""+y_value);
            z= new Double(""+z_value);
            this.timestamp = timestamp;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

    @Override
    public int compare(Acceleration o1, Acceleration o2) {
        return 0;
    }

    @Override
    public void onInserted(int position, int count) {

    }

    @Override
    public void onRemoved(int position, int count) {

    }

    @Override
    public void onMoved(int fromPosition, int toPosition) {

    }

    @Override
    public void onChanged(int position, int count) {

    }

    @Override
    public boolean areContentsTheSame(Acceleration oldItem, Acceleration newItem) {
        return false;
    }

    @Override
    public boolean areItemsTheSame(Acceleration item1, Acceleration item2) {
        return false;
    }
}


