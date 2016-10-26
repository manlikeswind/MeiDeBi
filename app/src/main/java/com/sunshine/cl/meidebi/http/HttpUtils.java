package com.sunshine.cl.meidebi.utils;

import android.os.Handler;

import com.sunshine.cl.meidebi.callback.DataCallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/10/18.
 */
public class HttpUtils {

    DataCallBack dataCallBack;
    public void setDataCallBack(DataCallBack dataCallBack) {
        this.dataCallBack = dataCallBack;
    }

    Handler handler = new Handler();
    private static HttpUtils httpUtils = null;
    public static HttpUtils getInstance(){
        if(httpUtils==null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }


    public void getDataFromNetWork(String path){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(path).build();
        Call call = client.newCall(request);
        if(call.isExecuted()){
            call.cancel();
        }

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String data = response.body().string();
                if(dataCallBack!=null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            dataCallBack.getDataCallBack(data);
                        }
                    });
                }
            }
        });
    }
}
