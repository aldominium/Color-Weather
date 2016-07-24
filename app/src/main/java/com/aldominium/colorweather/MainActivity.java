package com.aldominium.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);





    }


    @OnClick(R.id.dailyWeatherTextView)
    public void dailyWeatherClick(){

        Intent dailyActivityIntent = new Intent(MainActivity.this,DailyWeatherActivity.class);

        startActivity(dailyActivityIntent);
    }


}
