package com.sunshine.cl.meidebi.http;

import com.sunshine.cl.meidebi.callback.JsonCallBack;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/17.
 */
public class OKHttpGetUtils {

    Handler handler = new Handler();
    JsonCallBack jsonCallBack;
    String path;

    public OKHttpGetUtils(String path) {
        this.path = path;
    }

    public void setCallBack(JsonCallBack jsonCallBack) {
        this.jsonCallBack = jsonCallBack;
    }

    public void getJsonData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        jsonCallBack.getJsonCallBack(result);
                    }
                });
            }
        });
    }
}
