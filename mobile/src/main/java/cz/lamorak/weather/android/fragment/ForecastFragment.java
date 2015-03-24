package cz.lamorak.weather.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import cz.lamorak.weather.android.R;
import cz.lamorak.weather.android.adapter.ForecastAdapter;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {}

    public static ForecastFragment newInstance() {
        ForecastFragment fragment = new ForecastFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        GridView grid = (GridView) rootView.findViewById(R.id.forecast_grid);
        List<String> items = new ArrayList<String>(16);
        for (int i=0; i<16; i++) {
            items.add(i+"0°C");
        }
        grid.setAdapter(new ForecastAdapter(getActivity(), R.layout.item_forecast, items));
        return rootView;
    }
}
