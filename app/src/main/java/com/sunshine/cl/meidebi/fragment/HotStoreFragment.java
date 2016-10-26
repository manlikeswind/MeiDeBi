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
import com.sunshine.cl.meidebi.adapter.SearchHotGridViewGuoAdapter;
import com.sunshine.cl.meidebi.adapter.SearchHotGridViewHaiAdapter;
import com.sunshine.cl.meidebi.bean.HotStoreGridInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotStoreFragment extends Fragment implements JsonCallBack{

    GridView gridView1;
    GridView gridView2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_store, container, false);
        gridView1 = (GridView)view.findViewById(R.id.search_hot_gridView1);
        gridView2 = (GridView)view.findViewById(R.id.search_hot_gridView2);
        getShopInfo(Constants.SEARCH_HOT_GRID);
        return view;
    }

    public void getShopInfo(String path1){
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(HotStoreFragment.this);
    }

    @Override
    public void getJsonCallBack(String str) {
        Gson gson = new Gson();
        final HotStoreGridInfo info = gson.fromJson(str,HotStoreGridInfo.class);
        SearchHotGridViewHaiAdapter adapter1 = new SearchHotGridViewHaiAdapter(info.getData().getHaitao(),getActivity());
        gridView1.setAdapter(adapter1);
        SearchHotGridViewGuoAdapter adapter2 = new SearchHotGridViewGuoAdapter(info.getData().getGuonei(),getActivity());
        gridView2.setAdapter(adapter2);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HotStoreDetailActivity.class);
                intent.putExtra("id",info.getData().getHaitao().get(position).getId());
                intent.putExtra("name",info.getData().getHaitao().get(position).getName());
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), HotStoreDetailActivity.class);
                intent.putExtra("id",info.getData().getGuonei().get(position).getId());
                intent.putExtra("name",info.getData().getGuonei().get(position).getName());
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
    }
}
