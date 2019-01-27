package com.conways.httprequestframe.http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public abstract class HttpCallBack<T,K> implements ICallBack {

    private Handler handler;

    private WeakReference<K> weakReference;

    public HttpCallBack(K object) {
        this.weakReference = new WeakReference<>(object);
        handler = new Handler(Looper.getMainLooper());
    }

    public K weakObj() {
        return weakReference.get();
    }

    @Override
    public void onSuccess(String result) {
        Type type = this.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        Class<?> c = (Class<?>) types[0];
        final T t = (T) new Gson().fromJson(result, c);

        handler.post(new Runnable() {
            @Override
            public void run() {
                onSuccessed(t);
                onCompleted();
            }
        });
    }

    @Override
    public void onFailed(int code, final String msg) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailed(msg);
                onCompleted();
            }
        });
    }


    protected abstract void onSuccessed(T result);

    protected abstract void onFailed(String msg);

    protected void onCompleted() {

    }

}
