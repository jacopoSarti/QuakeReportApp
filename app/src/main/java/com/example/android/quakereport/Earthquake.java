package com.example.android.quakereport;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class Earthquake {

    private Double mMagnitude;
    private String mLocation;
    private Date mDate;
    private String mUrl;

    public Earthquake(Double magnitude, String location, long time, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = new Date(time);
        mUrl = url;
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

    public String getmUrl() {
        return mUrl;
    }
}
