package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mUrl;

    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {

        // create URL object from request string
        URL url = QueryUtils.createUrl(mUrl);

        // Perform HTTP Get request to the url address and receive a JSON response
        String jsonResponse = "";
        try {
            jsonResponse = QueryUtils.makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

            /*
            Extract information that we need to display from the JSON response
            and create a list of {@link Earthquake} objects
             */
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes(jsonResponse);

        return earthquakes;
    }
}
