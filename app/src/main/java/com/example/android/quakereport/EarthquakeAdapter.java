package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        TextView magnitudeTextView = (TextView) earthquakeView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentEarthquake.getmMagnitude().toString());

        TextView locationTextView = (TextView) earthquakeView.findViewById(R.id.location);
        locationTextView.setText(currentEarthquake.getmLocation());

        TextView dateTextView = (TextView) earthquakeView.findViewById(R.id.date);
        dateTextView.setText(currentEarthquake.getmDate());

        return earthquakeView;
    }
}
