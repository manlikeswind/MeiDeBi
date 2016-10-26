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
import com.sunshine.cl.meidebi.activity.ShowDetailActivity;
import com.sunshine.cl.meidebi.adapter.MyCommentListViewAdapter;
import com.sunshine.cl.meidebi.bean.HaiDetailInfo;
import com.sunshine.cl.meidebi.bean.MyCommentInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCommentFragment extends Fragment {

    ListView listView;
    SwipeRefreshLayout srl;

    List<MyCommentInfo.DataBean> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_comment, container, false);
        listView = (ListView)view.findViewById(R.id.my_comment_listView);
        srl = (SwipeRefreshLayout)view.findViewById(R.id.my_comment_srl);
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
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_COMMENT);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyCommentInfo info = gson.fromJson(str,MyCommentInfo.class);
                list = info.getData();
                listView.setAdapter(new MyCommentListViewAdapter(list,getActivity()));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                        if (list.get(position).getFromtype().equals("1")){
                            OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils("http://a.meidebi.com/new.php/Share-onelink?type=2&id="+list.get(position).getFromid()+"&devicetype=2&version=3.2.3");
                            okHttpGetUtils.getJsonData();
                            okHttpGetUtils.setCallBack(new JsonCallBack() {
                                @Override
                                public void getJsonCallBack(String str) {
                                    Gson gson1 = new Gson();
                                    HaiDetailInfo info1 = gson1.fromJson(str,HaiDetailInfo.class);
                                    int isabroad = info1.getData().getIsabroad();
                                    if (isabroad == 1){
                                        Intent intent = new Intent(getActivity(),AllListHaiDetailActivity.class);
                                        intent.putExtra("id",list.get(position).getFromid());
                                        startActivity(intent);
                                    }else {
                                        Intent intent = new Intent(getActivity(),AllListGuoDetailActivity.class);
                                        intent.putExtra("id",list.get(position).getFromid());
                                        startActivity(intent);
                                    }
                                }
                            });
                        }else if (list.get(position).getFromtype().equals("2")){
                            Intent intent = new Intent(getActivity(),ShowDetailActivity.class);
                            intent.putExtra("id",list.get(position).getFromid());
                            startActivity(intent);
                        }
                        getActivity().overridePendingTransition(R.anim.in,0);
                    }
                });
            }
        });
    }

}
