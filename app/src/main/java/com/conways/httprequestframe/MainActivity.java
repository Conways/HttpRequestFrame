package com.conways.httprequestframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.conways.httprequestframe.entity.WeatherEntity;
import com.conways.httprequestframe.http.HttpCallBack;
import com.conways.httprequestframe.http.HttpClient;
import com.conways.httprequestframe.http.OkRequest;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.hello);
        HttpClient.getInstance().init(new OkRequest());
        HttpClient.getInstance().get("http://www.weather.com.cn/data/sk/101110101.html", null,
                new HttpCallBack<WeatherEntity, MainActivity>(this) {
                    @Override
                    protected void onSuccessed(WeatherEntity result) {
                        weakObj().tv.setText(result.getWeatherinfo().toString());
                    }

                    @Override
                    protected void onFailed(String msg) {

                    }

                    @Override
                    protected void onCompleted() {
                        super.onCompleted();
                    }
                });
    }

}
