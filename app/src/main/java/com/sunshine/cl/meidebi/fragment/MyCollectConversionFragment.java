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
import com.sunshine.cl.meidebi.activity.ConversionDetailActivity;
import com.sunshine.cl.meidebi.adapter.MyCollectListViewAdapter;
import com.sunshine.cl.meidebi.bean.MyCollectInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectConversionFragment extends Fragment {

    ListView listView;
    SwipeRefreshLayout srl;

    List<MyCollectInfo.DataBean> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_collect_conversion, container, false);
        listView = (ListView) view.findViewById(R.id.my_collect_conversion_listView);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.my_collect_conversion_srl);
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
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_COLLECT_CONVERSION);
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
                        Intent intent = new Intent(getActivity(), ConversionDetailActivity.class);
                        intent.putExtra("id", list.get(position).getId());
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.in, 0);
                    }
                });
            }
        });
    }
}
