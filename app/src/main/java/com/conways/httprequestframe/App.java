package com.conways.httprequestframe;

import android.app.Application;

import com.conways.httprequestframe.http.HttpClient;
import com.conways.httprequestframe.http.OkRequest;

/**
 * Created by Conways on 2019/1/28
 * Describe:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initHttp();
    }

    private void initHttp() {
        HttpClient.getInstance().init(new OkRequest());
    }
}
