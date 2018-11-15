package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private Double mMagnitude;
    private String mLocation;
    private Date mDate;

    public Earthquake(Double magnitude, String location, Date date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
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
