package com.conways.httprequestframe.http;

import java.util.HashMap;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public interface IRequest {

    void get(String url, HashMap<String, Object> params, ICallBack iCallBack);

    void post(String url, HashMap<String, Object> params, ICallBack iCallBack);
}
