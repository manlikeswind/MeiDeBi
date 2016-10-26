package com.sunshine.cl.meidebi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.AllListGuoDetailActivity;
import com.sunshine.cl.meidebi.activity.AllListHaiDetailActivity;
import com.sunshine.cl.meidebi.adapter.MyCollectListViewAdapter;
import com.sunshine.cl.meidebi.bean.HaiDetailInfo;
import com.sunshine.cl.meidebi.bean.MyCollectInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectFavorableFragment extends Fragment {

    ListView listView;
    SwipeRefreshLayout srl;

    List<MyCollectInfo.DataBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_collect_favorable, container, false);
        listView = (ListView) view.findViewById(R.id.my_collect_favorable_listView);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.my_collect_favorable_srl);
        setListViewData();

        TextView view1 = new TextView(getActivity());
        view1.setText("已经是最后一条");
        view1.setGravity(Gravity.CENTER_HORIZONTAL);
        view1.setPadding(0, 10, 0, 10);
        listView.addFooterView(view1);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setListViewData();
                srl.setRefreshing(false);
            }
        });
        return view;
    }

    public void setListViewData() {
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_COLLECT_FAVO);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyCollectInfo info = gson.fromJson(str, MyCollectInfo.class);
                list = info.getData();
                listView.setAdapter(new MyCollectListViewAdapter(list, getActivity()));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils("http://a.meidebi.com/new.php/Share-onelink?type=2&id=" + list.get(position).getId() + "&devicetype=2&version=3.2.3");
                        okHttpGetUtils.getJsonData();
                        okHttpGetUtils.setCallBack(new JsonCallBack() {
                            @Override
                            public void getJsonCallBack(String str) {
                                Gson gson1 = new Gson();
                                HaiDetailInfo info1 = gson1.fromJson(str, HaiDetailInfo.class);
                                int isabroad = info1.getData().getIsabroad();
                                if (isabroad == 1) {
                                    Intent intent = new Intent(getActivity(), AllListHaiDetailActivity.class);
                                    intent.putExtra("id", list.get(position).getId());
                                    startActivity(intent);
                                } else {
                                    Intent intent = new Intent(getActivity(), AllListGuoDetailActivity.class);
                                    intent.putExtra("id", list.get(position).getId());
                                    startActivity(intent);
                                }
                                getActivity().overridePendingTransition(R.anim.in, 0);
                            }
                        });
                    }
                });
            }
        });
    }
}
