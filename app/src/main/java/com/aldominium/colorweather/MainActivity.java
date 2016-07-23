package com.aldominium.colorweather;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private TextView dailyWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailyWeatherTextView = (TextView) findViewById(R.id.dailyWeatherTextView);

        dailyWeatherTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Click en daily Text View");
            }
        });

    }



}
