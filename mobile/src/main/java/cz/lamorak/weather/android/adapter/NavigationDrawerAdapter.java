package cz.lamorak.weather.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cz.lamorak.weather.android.entity.NavigationDrawerItem;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerItem> {
    private final int resource;

    public NavigationDrawerAdapter(Context context, int resource, List<NavigationDrawerItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NavigationDrawerItem item = getItem(position);
        viewHolder.textView.setText(item.getTextResource());
        viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(item.getIconResource(), 0, 0 , 0);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
