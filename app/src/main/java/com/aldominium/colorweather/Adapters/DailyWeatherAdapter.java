package com.aldominium.colorweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aldominium.colorweather.Day;
import com.aldominium.colorweather.R;

import java.util.ArrayList;

/**
 * Created by aldo on 24/07/2016.
 */

public class DailyWeatherAdapter extends BaseAdapter{

    ArrayList<Day> days;
    Context context;

    public DailyWeatherAdapter(Context context, ArrayList<Day> days){
        this.context = context;
        this.days = days;
    }

    @Override
    public int getCount() {
        return days.size();
    }

    @Override
    public Object getItem(int position) {

        return days.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;//No lo usaremos
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Day day = days.get(position);

        view = LayoutInflater.from(context).inflate(R.layout.daily_list_item,null);

        TextView dayTitle = (TextView) view.findViewById(R.id.dailyListTitle);
        TextView dayDescription = (TextView) view.findViewById(R.id.dailyListDescription);
        TextView dayRainProbability = (TextView) view.findViewById(R.id.dailyListProbability);


        dayTitle.setText(day.getDayName());
        dayDescription.setText(day.getWeatherDescription());
        dayRainProbability.setText(day.getRainProbability());

        return view;
    }
}
