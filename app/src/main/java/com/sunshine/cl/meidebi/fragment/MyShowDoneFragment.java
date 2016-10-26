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
import android.widget.Toast;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.ShowDetailActivity;
import com.sunshine.cl.meidebi.adapter.MyShowListViewAdapter;
import com.sunshine.cl.meidebi.bean.MyShowInfo;
import com.sunshine.cl.meidebi.bean.ShowDetailInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyShowDoneFragment extends Fragment {

    ListView listView;
    SwipeRefreshLayout srl;

    List<MyShowInfo.DataBean> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_show_done, container, false);
        listView = (ListView) view.findViewById(R.id.my_show_done_listView);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.my_show_done_srl);
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
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(Constants.MIME.MY_SHOW_DONE);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                MyShowInfo info = gson.fromJson(str, MyShowInfo.class);
                list = info.getData();
                listView.setAdapter(new MyShowListViewAdapter(list, getActivity()));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                        if (list.get(position).getStatus().equals("0")){
                            Toast.makeText(getActivity(), "审核未通过，信息越详细越容易通过哟", Toast.LENGTH_SHORT).show();
                        }else {
                            Intent intent = new Intent(getActivity(), ShowDetailActivity.class);
                            intent.putExtra("id", list.get(position).getId());
                            startActivity(intent);
                            getActivity().overridePendingTransition(R.anim.in, 0);
                        }
                    }
                });
            }
        });
    }

}
