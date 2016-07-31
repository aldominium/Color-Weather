package com.aldominium.colorweather;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.aldominium.colorweather.Adapters.HourlyWeatherAdapter;

import java.util.ArrayList;

public class HourlyWeatherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);

        Hour hour = new Hour();
        hour.setTitle("11:00pm");
        hour.setWeatherDescription("There is a storm");

        ArrayList<Hour> hours = new ArrayList<Hour>();
        hours.add(hour);

        HourlyWeatherAdapter hourlyWeatherAdapter = new HourlyWeatherAdapter(this,hours);

        

    }
}
