package com.it.bruce.leetcode.visitationScheduleWorker;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {
    public static String doGet(String url) {
        String body = "";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity, Consts.UTF_8);
            httpGet.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}
