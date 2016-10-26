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

import java.util.List;

public class UnderAdActivity extends AppCompatActivity {

    ImageView img_back;
    TextView tv_title;
    SwipeRefreshLayout srl;
    ListView listView;
    ProgressBar progressBar;
    List<AllListViewInfo.DataBean.LinklistBean> list;
    AllListViewAdapter adapter;

    boolean flag1 = false;
    int p = 1;
    String share = "";
    String path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&devicetype=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_ad);
        share = getIntent().getStringExtra("share");
        int flag = getIntent().getIntExtra("flag", 0);
        path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&devicetype=2";
        img_back = (ImageView) findViewById(R.id.under_ad_back);
        tv_title = (TextView) findViewById(R.id.under_ad_title);
        srl = (SwipeRefreshLayout) findViewById(R.id.under_ad_srl);
        listView = (ListView) findViewById(R.id.under_ad_listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (flag == 0) {
            tv_title.setText("海淘直邮");
        } else if (flag == 1) {
            tv_title.setText("优惠券直播");
        } else {
            tv_title.setText("白菜价");
        }
        setListViewData(path);
        refreshMoreData();

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
                overridePendingTransition(0, R.anim.out);
            }
        });
    }

    public void setListViewData(String path1) {
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                AllListViewInfo info = gson.fromJson(str, AllListViewInfo.class);
                list = info.getData().getLinklist();
                adapter = new AllListViewAdapter(list, UnderAdActivity.this);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (list.get(position).getIsabroad() == 1) {
                            Intent intent = new Intent(UnderAdActivity.this, AllListHaiDetailActivity.class);
                            intent.putExtra("id", list.get(position).getId());
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(UnderAdActivity.this, AllListGuoDetailActivity.class);
                            intent.putExtra("id", list.get(position).getId());
                            startActivity(intent);
                        }
                        overridePendingTransition(R.anim.in, 0);
                    }
                });
            }
        });
    }

    public void refreshMoreData() {
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
                                    path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&devicetype=2";
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
        overridePendingTransition(0, R.anim.out);
    }
}
