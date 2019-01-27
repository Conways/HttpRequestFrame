package com.conways.httprequestframe.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public class OkRequest implements IRequest {
    private static OkHttpClient httpClient;

    static {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                });
        httpClient = okHttpBuilder.build();

    }


    @Override
    public void get(String url, HashMap<String, Object> params, final ICallBack iCallBack) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        if (null != params && params.size() > 0) {
            StringBuilder urlBuilder = new StringBuilder(url);
            urlBuilder.append("?");
            int position = 0;
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey() + "=");
                ++position;
                urlBuilder.append(position == params.size() ? entry.getValue() : entry.getValue() + "&");
            }
            builder.url(urlBuilder.toString());
        } else {
            builder.url(url);
        }
        httpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.onFailed(10001, e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    iCallBack.onSuccess(response.body().string());
                } else {
                    iCallBack.onFailed(response.code(), response.message());
                }
            }
        });
    }

    @Override
    public void post(String url, HashMap<String, Object> params, ICallBack iCallBack) {

    }


}
