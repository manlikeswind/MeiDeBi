package com.sunshine.cl.meidebi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.activity.ConversionDetailActivity;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.AllRefreshListViewAdapter;
import com.sunshine.cl.meidebi.adapter.TicketRecyclerAdapter;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;
import com.sunshine.cl.meidebi.bean.TicketInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.util.List;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversionFragment extends Fragment implements DataCallBack {

    String path = Constants.CONVERSION.CONVERSION_LIST;
    SwipeRefreshLayout mRefresh;
    RecyclerView mRecycler;
    LinearLayoutManager layoutManager;
    TicketRecyclerAdapter refreshAdapter;

    public void loadData(String path) {
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(path);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conversion, container, false);
        mRecycler = (RecyclerView) view.findViewById(R.id.conversion_recycler);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.conversion_refresh);
        layoutManager = new LinearLayoutManager(getActivity());
        loadData(path);
        mRecycler.setLayoutManager(layoutManager);
        mRefresh.setColorSchemeResources(R.color.orange);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData(path);
                        //将下拉进度收起
                        mRefresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        return view;
    }


    @Override
    public void getDataCallBack(String data) {
        TicketInfo ticketInfo = new Gson().fromJson(data, TicketInfo.class);
        final List<TicketInfo.DataEntity.LinklistEntity> tickerBean = ticketInfo.getData().getLinklist();
        refreshAdapter = new TicketRecyclerAdapter(tickerBean, getActivity());
        mRecycler.setAdapter(refreshAdapter);
        refreshAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //设置点击事件
                Intent intent = new Intent(getActivity(), ConversionDetailActivity.class);
                intent.putExtra("id", tickerBean.get(position).getId());
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
    }
}

