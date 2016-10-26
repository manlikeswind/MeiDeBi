package com.sunshine.cl.meidebi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.HotStoreDetailActivity;
import com.sunshine.cl.meidebi.activity.TradeClassDetailActivity;
import com.sunshine.cl.meidebi.adapter.SearchClassGridViewAdapter;
import com.sunshine.cl.meidebi.bean.TradeClassGridInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class TradeClassFragment extends Fragment implements JsonCallBack{

    GridView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trade_class, container, false);
        gridView = (GridView)view.findViewById(R.id.search_class_gridView);
        getShopInfo(Constants.SEARCH_CLASS_GRID);
        return view;
    }

    public void getShopInfo(String path1){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(TradeClassFragment.this);
    }

    @Override
    public void getJsonCallBack(String str) {
        Gson gson = new Gson();
        final TradeClassGridInfo info = gson.fromJson(str,TradeClassGridInfo.class);
        SearchClassGridViewAdapter adapter = new SearchClassGridViewAdapter(info.getData(),getActivity());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TradeClassDetailActivity.class);
                intent.putExtra("id",info.getData().get(position).getId());
                intent.putExtra("name",info.getData().get(position).getName());
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
    }
}
