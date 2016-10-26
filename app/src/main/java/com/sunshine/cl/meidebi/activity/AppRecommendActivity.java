package com.sunshine.cl.meidebi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.AppRecommendListViewAdapter;
import com.sunshine.cl.meidebi.bean.AppRecommendInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.util.List;

public class AppRecommendActivity extends AppCompatActivity implements DataCallBack{

    ImageView mBack;
    ListView mListView;
    AppRecommendListViewAdapter mAdapter;
    WindowManager.LayoutParams layoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_recommend);
        layoutParams  = new WindowManager.LayoutParams();

        mBack = (ImageView) findViewById(R.id.app_back);
        mListView = (ListView) findViewById(R.id.app_recommend_list);
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(Constants.MIME.APP_RECOMMEND);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
        }
        });
    }

    @Override
    public void getDataCallBack(String data) {
        AppRecommendInfo appRecommendInfo = new Gson().fromJson(data,AppRecommendInfo.class);
        List<AppRecommendInfo.DataBean> beanList = appRecommendInfo.getData();
        mAdapter = new AppRecommendListViewAdapter(beanList,AppRecommendActivity.this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}
