package com.example.android.quakereport;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class EarthquakePreferenceFragment extends PreferenceFragment  implements Preference.OnPreferenceChangeListener {
        Preference starttime,endtime;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);
            //find the prefernce object and set up the summary using helper method
            Preference minMagnitude = findPreference(getString(R.string.settings_min_magnitude_key));
            bindPreferenceSummaryToValue(minMagnitude);

            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            bindPreferenceSummaryToValue(orderBy);

            starttime = findPreference(getString(R.string.settings_starttime_key));
            bindPreferenceSummaryToValue(starttime);

            endtime = findPreference(getString(R.string.settings_endtime_key));
            bindPreferenceSummaryToValue(endtime);

            Preference setDate_Checkbox =findPreference(getString(R.string.settings_checkbox_key));
            setDate_Checkbox.setOnPreferenceChangeListener(this);
            SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(setDate_Checkbox.getContext());
            Boolean setDate_Value=preferences.getBoolean(setDate_Checkbox.getKey(),false);
            onPreferenceChange(setDate_Checkbox,setDate_Value);

        }
        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceValue = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceValue);

        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            if (preference instanceof ListPreference) {
                String stringValue = newValue.toString();
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            }
            else if(preference instanceof CheckBoxPreference) {
                Boolean bool = (Boolean) newValue;
                if (bool) {
                    starttime.setEnabled(true);
                    endtime.setEnabled(true);
                } else {
                    starttime.setEnabled(false);
                    endtime.setEnabled(false);
                }
            }
            else{
                String stringValue = newValue.toString();
                preference.setSummary(stringValue);
            }
            return true;
        }
    }
}