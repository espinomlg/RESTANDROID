package com.espino.com.sitiosrest;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by espino on 13/02/17.
 */

public class RestClient {
    private static final String BASE_URL = "https://andres.alumno.club/";
    private static final int MAX_TIMEOUT = 10000;
    private static final int RETRIES = 3;
    private static final int TIMEOUT_BETWEEN_RETRIES = 5000;
    private static AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);

    public static void get(String url, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(MAX_TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT_BETWEEN_RETRIES);
        client.get(getAbsoluteUrl(url), responseHandler);
    }
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(MAX_TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT_BETWEEN_RETRIES);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(MAX_TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT_BETWEEN_RETRIES);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void put(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(MAX_TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT_BETWEEN_RETRIES);
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }
    public static void delete(String url, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(MAX_TIMEOUT);
        client.setMaxRetriesAndTimeout(RETRIES, TIMEOUT_BETWEEN_RETRIES);
        client.delete(getAbsoluteUrl(url), responseHandler);
    }
    public static void cancelRequests(Context c, boolean flag) {
        client.cancelRequests(c, flag);
    }
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
