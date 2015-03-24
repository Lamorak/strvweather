package cz.lamorak.weather.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cz.lamorak.weather.android.R;

public class ForecastAdapter extends ArrayAdapter<String> {

    private int resource;

    public ForecastAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.forecast_icon);
            viewHolder.day = (TextView) convertView.findViewById(R.id.forecast_day);
            viewHolder.temperature = (TextView) convertView.findViewById(R.id.forecast_temperature);
            viewHolder.conditions = (TextView) convertView.findViewById(R.id.forecast_conditions);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.temperature.setText(getItem(position));

        return convertView;
    }

    private static class ViewHolder {
        ImageView icon;
        TextView day;
        TextView temperature;
        TextView conditions;
    }
}
