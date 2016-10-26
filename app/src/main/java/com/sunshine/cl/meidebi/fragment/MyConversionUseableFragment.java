package com.sunshine.cl.meidebi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.MyConversionUseableListViewAdapter;
import com.sunshine.cl.meidebi.bean.MyConversionUseableInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyConversionUseableFragment extends Fragment {

    ListView listView;
    SwipeRefreshLayout srl;

    List<MyConversionUseableInfo.DataBean> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_conversion_useable, container, false);
        listView = (ListView)view.findViewById(R.id.my_conversion_useable_listView);
        srl = (SwipeRefreshLayout)view.findViewById(R.id.my_conversion_useable_srl);
        setListViewData();

        TextView view1 = new TextView(getActivity());
        view1.setText("已经是最后一条");
        view1.setGravity(Gravity.CENTER_HORIZONTAL);
        view1.setPadding(0,10,0,10);
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

    public void setListViewData(){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_CONVERSION_USEABLE);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyConversionUseableInfo info = gson.fromJson(str,MyConversionUseableInfo.class);
                list = info.getData();
                listView.setAdapter(new MyConversionUseableListViewAdapter(list,getActivity()));
            }
        });
    }
}
