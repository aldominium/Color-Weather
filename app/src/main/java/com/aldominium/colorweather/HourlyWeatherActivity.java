package com.aldominium.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aldominium.colorweather.Adapters.HourlyWeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyWeatherActivity extends Activity {

    @BindView(R.id.hourlyListView) ListView hourlyListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        ArrayList<Hour> hours = intent.getParcelableArrayListExtra(MainActivity.HOUR_ARRAY_LIST);

        HourlyWeatherAdapter hourlyWeatherAdapter = new HourlyWeatherAdapter(this,hours);

        hourlyListView.setAdapter(hourlyWeatherAdapter);

    }
}
