package cz.lamorak.weather.android.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import cz.lamorak.weather.android.R;

public class SettingsFragment extends PreferenceFragment {

    public SettingsFragment() {}

    public static SettingsFragment newInstance() {
        SettingsFragment fragment =  new SettingsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
