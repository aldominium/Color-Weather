package com.aldominium.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.iconImageView) ImageView iconImageView;
    @BindView(R.id.descriptionTextView) TextView descriptionTextView;
    @BindView(R.id.currentTempTextView) TextView currentTempTextView;
    @BindView(R.id.highestTempTextView) TextView highestTempTextView;
    @BindView(R.id.lowestTempTextView) TextView lowestTempTextView;

    @BindDrawable(R.drawable.clear_night) Drawable clearNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);







        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url ="https://api.forecast.io/forecast/60bc1f5d441bc55a501a13b4c29d9302/37.8267,-122.423";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            CurrentWeather currentWeather = getCurrentWeatherFromJson(response);

                            iconImageView.setImageDrawable(currentWeather.getIconDrawableResource());
                            descriptionTextView.setText(currentWeather.getDescription());
                            currentTempTextView.setText(currentWeather.getCurrentTemperature());
                            highestTempTextView.setText(currentWeather.getHighestTemperature());
                            lowestTempTextView.setText(currentWeather.getLowestTemperature());



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,"Eso no funciono");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    @OnClick(R.id.dailyWeatherTextView)
    public void dailyWeatherClick(){

        Intent dailyActivityIntent = new Intent(MainActivity.this,DailyWeatherActivity.class);

        startActivity(dailyActivityIntent);

    }


    @OnClick(R.id.hourlyWeatherTextView)
    public void hourlyWeatherClick(){

        Intent hourlyActivityIntent = new Intent(MainActivity.this,HourlyWeatherActivity.class);

        startActivity(hourlyActivityIntent);

    }


    @OnClick(R.id.minutelyWeatherTextView)
    public void minutelyWeatherClick(){

        Intent minutelyActivityIntent = new Intent(MainActivity.this,MinutelyWeatherActivity.class);

        startActivity(minutelyActivityIntent);

    }

    private CurrentWeather getCurrentWeatherFromJson(String json)throws JSONException{

        JSONObject jsonObject = new JSONObject(json);

        JSONObject jsonWithCurrentWeather = jsonObject.getJSONObject("currently");

        JSONObject jsonWithDailyWeather = jsonObject.getJSONObject("daily");

        JSONArray jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray("data");

        JSONObject jsonWithTodayData = jsonWithDailyWeatherData.getJSONObject(0);


        String summary = jsonWithCurrentWeather.getString("summary");

        String icon = jsonWithCurrentWeather.getString("icon");

        String temperature = jsonWithCurrentWeather.getDouble("temperature") + "";

        String maxTemperature = jsonWithTodayData.getDouble("temperatureMax") + "";

        String minTemperature = jsonWithTodayData.getDouble("temperatureMin") + "";


        CurrentWeather currentWeather = new CurrentWeather(MainActivity.this);

        currentWeather.setDescription(summary);
        currentWeather.setIconImage(icon);
        currentWeather.setCurrentTemperature(temperature);
        currentWeather.setHighestTemperature(maxTemperature);
        currentWeather.setLowestTemperature(minTemperature);

        return currentWeather;



    }


}
