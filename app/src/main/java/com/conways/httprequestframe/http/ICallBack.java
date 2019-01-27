package com.conways.httprequestframe.http;

/**
 * Created by Conways on 2019/1/27
 * Describe:
 */
public interface ICallBack {

    void onSuccess(String result);

    void onFailed(int code, String msg);

}
