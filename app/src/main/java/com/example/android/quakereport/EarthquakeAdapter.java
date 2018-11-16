package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter (Context context, ArrayList<Earthquake> data) {
        super(context, 0 , data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View earthquakeView = convertView;
        if (earthquakeView == null) {
            earthquakeView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        String originalLocation = currentEarthquake.getmLocation();
        String primaryLocation;
        String locationOffset;

        // looks for the separator, if true splits the string using separator
        // if false uses default offset "near the" and full location as primary location
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        // format magnitude as a one decimal number and display it in TextView
        TextView magnitudeTextView = (TextView) earthquakeView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeTextView.setText(formatter.format(currentEarthquake.getmMagnitude()));

        // set proper color for the magnitude circle
        // fetch background circle reference from parent view
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // get appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        // display location offset in textview
        TextView locationOffsetTextView = (TextView) earthquakeView.findViewById(R.id.location_offset);
        locationOffsetTextView.setText(locationOffset);

        // display primary location in textview
        TextView primaryLocationTextView = (TextView) earthquakeView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);

        // format the date and display it in textview
        TextView dateTextView = (TextView) earthquakeView.findViewById(R.id.date);
        dateTextView.setText(formatDate(currentEarthquake.getmDate(), "MMM DD, yyyy"));

        // format time of the day and display it in textview
        TextView timeTextView = (TextView) earthquakeView.findViewById(R.id.time);
        timeTextView.setText(formatTime(currentEarthquake.getmDate(), "HH:mm a"));

        return earthquakeView;
    }

    public static String formatDate(Date date, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        return formatter.format(date.getDate());
    }

    public static String formatTime(Date date, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        return formatter.format(date.getTime());
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int)Math.floor(magnitude);
        switch(magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
