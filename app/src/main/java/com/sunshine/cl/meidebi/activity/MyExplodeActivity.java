package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.MyExplodeListViewAdapter;
import com.sunshine.cl.meidebi.bean.MyExplodeInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;
import com.google.gson.Gson;

import java.util.List;

public class MyExplodeActivity extends AppCompatActivity {

    ImageView img_back;
    ListView listView;
    SwipeRefreshLayout srl;

    List<MyExplodeInfo.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_explode);
        img_back = (ImageView)findViewById(R.id.my_explode_back);
        srl = (SwipeRefreshLayout)findViewById(R.id.my_explode_srl);
        listView = (ListView)findViewById(R.id.my_explode_listView);

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
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_EXPLODE);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyExplodeInfo info = gson.fromJson(str,MyExplodeInfo.class);
                list = info.getData();
                listView.setAdapter(new MyExplodeListViewAdapter(list,MyExplodeActivity.this));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MyExplodeActivity.this, AllListGuoDetailActivity.class);
                        intent.putExtra("id", list.get(position).getId());
                        startActivity(intent);
                        overridePendingTransition(R.anim.in, 0);
                    }
                });
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
