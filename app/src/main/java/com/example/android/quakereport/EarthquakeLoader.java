package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context,String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        Log.i(LOG_TAG,"TEST:EarthquakeLoader onStartLoading() called");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG,"TEST:EarthquakeLoader loadInBackground() called");
        // Don't perform the request if there are no URLs, or the first URL is null
        if ((mUrl == null)) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
}
