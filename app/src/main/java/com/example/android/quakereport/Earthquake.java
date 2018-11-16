package com.example.android.quakereport;

import android.text.method.DateTimeKeyListener;

import java.util.Date;

public class Earthquake {

    private Double mMagnitude;
    private String mLocation;
    private Long mDate;

    public Earthquake(Double magnitude, String location, Long date) {
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

    public Long getmDate() {
        return mDate;
    }
}
