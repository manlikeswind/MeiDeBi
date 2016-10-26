package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.AllListViewAdapter;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.net.URLEncoder;

public class HotStoreDetailActivity extends AppCompatActivity {

    ImageView img_back;
    TextView tv_title;
    RadioGroup radioGroup;
    SwipeRefreshLayout srl;
    ListView listView;
    ProgressBar progressBar;
    List<AllListViewInfo.DataBean.LinklistBean> list;
    AllListViewAdapter adapter;

    boolean flag1 = false;
    String id;
    String name;
    int p = 1;
    String share = "allhotlist";
    String path = "http://a.meidebi.com/new.php/Share-"+share+"?version=3.2.3&cats="+name+"&devicetoken=352284040670808&siteid="+id+"&limit=20&p="+p+"&type="+id+"&devicetype=2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_store_detail);
        id = getIntent().getStringExtra("id");
        String names = getIntent().getStringExtra("name");
        try {
            name = URLEncoder.encode(names,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        path = "http://a.meidebi.com/new.php/Share-"+share+"?version=3.2.3&cats="+name+"&devicetoken=352284040670808&siteid="+id+"&limit=20&p="+p+"&type="+id+"&devicetype=2";
        img_back = (ImageView)findViewById(R.id.search_hot_con_back);
        tv_title = (TextView)findViewById(R.id.search_hot_con_title);
        radioGroup = (RadioGroup)findViewById(R.id.search_hot_con_radioGroup);
        srl = (SwipeRefreshLayout)findViewById(R.id.search_hot_con_srl);
        listView = (ListView)findViewById(R.id.search_hot_con_listView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        setListViewData(path);
        setChangeListViewData();
        refreshMoreData();

        tv_title.setText(names);
        tv_title.setTypeface(Typeface.DEFAULT_BOLD);
        srl.setColorSchemeColors(getResources().getColor(R.color.colorRefreash));
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setListViewData(path);
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

    public void setListViewData(String path1){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                AllListViewInfo info = gson.fromJson(str,AllListViewInfo.class);
                list = info.getData().getLinklist();
                adapter = new AllListViewAdapter(list,HotStoreDetailActivity.this);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getIsabroad() == 1){
                            Intent intent = new Intent(HotStoreDetailActivity.this,AllListHaiDetailActivity.class);
                            intent.putExtra("id",list.get(position).getId());
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(HotStoreDetailActivity.this,AllListGuoDetailActivity.class);
                            intent.putExtra("id",list.get(position).getId());
                            startActivity(intent);
                        }
                        overridePendingTransition(R.anim.in,0);
                    }
                });
            }
        });
    }

    public void setChangeListViewData(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                p=1;
                switch (checkedId){
                    case R.id.search_hot_con_essence:
                        share = "allhotlist";
                        path = "http://a.meidebi.com/new.php/Share-"+share+"?version=3.2.3&cats="+name+"&devicetoken=352284040670808&siteid="+id+"&limit=20&p="+p+"&type="+id+"&devicetype=2";
                        srl.setRefreshing(true);
                        setListViewData(path);
                        srl.setRefreshing(false);
                        break;
                    case R.id.search_hot_con_newest:
                        share = "alllist";
                        path = "http://a.meidebi.com/new.php/Share-"+share+"?version=3.2.3&cats="+name+"&devicetoken=352284040670808&siteid="+id+"&limit=20&p="+p+"&type="+id+"&devicetype=2";
                        srl.setRefreshing(true);
                        setListViewData(path);
                        srl.setRefreshing(false);
                        break;
                }
            }
        });
    }

    public void refreshMoreData(){
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case 0:
                        if (flag1) {
                            progressBar.setVisibility(View.VISIBLE);
                            progressBar.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setVisibility(View.GONE);
                                    p++;
                                    path = "http://a.meidebi.com/new.php/Share-"+share+"?version=3.2.3&cats="+name+"&devicetoken=352284040670808&siteid="+id+"&limit=20&p="+p+"&type="+id+"&devicetype=2";
                                    OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path);
                                    okHttpGetUtils.getJsonData();
                                    okHttpGetUtils.setCallBack(new JsonCallBack() {
                                        @Override
                                        public void getJsonCallBack(String str) {
                                            Gson gson = new Gson();
                                            AllListViewInfo info = gson.fromJson(str, AllListViewInfo.class);
                                            List<AllListViewInfo.DataBean.LinklistBean> list1 = info.getData().getLinklist();
                                            list.addAll(list1);
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }, 1000);
                        }
                        break;
                    case 1:
//                        if (flag1) {
//                            progressBar.setVisibility(View.VISIBLE);
//                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
                if (firstVisibleItem == 0) {
                    srl.setEnabled(true);
                }else {
                    srl.setEnabled(false);
                }
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
