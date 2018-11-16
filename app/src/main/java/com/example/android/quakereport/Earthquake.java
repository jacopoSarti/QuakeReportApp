package com.example.android.quakereport;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class Earthquake {

    private Double mMagnitude;
    private String mLocation;
    private Date mDate;

    public Earthquake(Double magnitude, String location, long time) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = new Date(time);
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Date getmDate() {
        return mDate;
    }
}
