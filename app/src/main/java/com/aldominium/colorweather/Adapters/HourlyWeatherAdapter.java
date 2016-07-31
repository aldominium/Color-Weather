package com.aldominium.colorweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aldominium.colorweather.Hour;
import com.aldominium.colorweather.R;

import java.util.ArrayList;

/**
 * Created by aldo on 30/07/2016.
 */

public class HourlyWeatherAdapter extends BaseAdapter {

    ArrayList<Hour> hours;
    Context context;

    public HourlyWeatherAdapter(Context context, ArrayList<Hour> hours){

        this.context = context;
        this.hours = hours;

    }

    @Override
    public int getCount() {
        return hours.size();
    }

    @Override
    public Object getItem(int i) {
        return hours.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;//We dont use this
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        Hour hour = hours.get(i);

        if (view == null){

            view = LayoutInflater.from(context).inflate(R.layout.hourly_list_item,viewGroup,false);

            viewHolder = new ViewHolder();

            viewHolder.title = (TextView) view.findViewById(R.id.hourlyTitleTextView);
            viewHolder.description = (TextView) view.findViewById(R.id.hourlyDescriptionTextView);

            view.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) view.getTag();

        }

        viewHolder.description.setText(hour.getWeatherDescription());
        viewHolder.title.setText(hour.getTitle());



        return view;
    }

    static class ViewHolder{
        TextView title;
        TextView description;

    }


}
