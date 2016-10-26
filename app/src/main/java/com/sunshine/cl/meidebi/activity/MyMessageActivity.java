package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.MyMessageListViewAdapter;
import com.sunshine.cl.meidebi.bean.MyMessageInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

public class MyMessageActivity extends AppCompatActivity {

    ImageView img_back;
    ListView listView;
    SwipeRefreshLayout srl;

    List<MyMessageInfo.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_message);
        img_back = (ImageView)findViewById(R.id.my_message_back);
        srl = (SwipeRefreshLayout)findViewById(R.id.my_message_srl);
        listView = (ListView)findViewById(R.id.my_message_listView);

        setListViewData();

        TextView view = new TextView(this);
        view.setText("已经是最后一条");
        view.setGravity(Gravity.CENTER_HORIZONTAL);
        view.setPadding(0,10,0,10);
        listView.addFooterView(view);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setListViewData();
                srl.setRefreshing(false);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
    }

    public void setListViewData(){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_MESSAGE);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyMessageInfo info = gson.fromJson(str,MyMessageInfo.class);
                list = info.getData();
                listView.setAdapter(new MyMessageListViewAdapter(list,MyMessageActivity.this));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}
