package com.conways.httprequestframe.http;

import java.util.HashMap;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public class HttpClient implements IRequest {
    private static HttpClient ourInstance;
    private static final String BASE_URL = "";

    public static HttpClient getInstance() {
        synchronized (HttpClient.class) {
            if (null == ourInstance) {
                ourInstance = new HttpClient();
            }
        }
        return ourInstance;
    }


    private IRequest iRequest;

    private HttpClient() {

    }

    public void init(IRequest iRequest) {
        this.iRequest = iRequest;
    }

    @Override
    public void get(String url, HashMap<String, Object> params, ICallBack iCallBack) {
        if (null == iRequest) {
            throw new NullPointerException("please call init(IRequest iRequest) befor use this!");
        }
        iRequest.get(BASE_URL + url, params, iCallBack);
    }

    @Override
    public void post(String url, HashMap<String, Object> params, ICallBack iCallBack) {
        if (null == iRequest) {
            throw new NullPointerException("please call init(IRequest iRequest) befor use this!");
        }
        iRequest.post(BASE_URL + url, params, iCallBack);
    }
}
