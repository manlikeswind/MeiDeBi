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
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.AllListGuoDetailActivity;
import com.sunshine.cl.meidebi.activity.AllListHaiDetailActivity;
import com.sunshine.cl.meidebi.adapter.AllRefreshListViewAdapter;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverseasShoppingBoutiqueFragment extends BaseFragment implements DataCallBack{
    boolean isPrepared = false;
    String path;
    SwipeRefreshLayout mSwipeRefresh;
    RecyclerView mRecycler;
    AllRefreshListViewAdapter refreshAdapter;

    String newPath;//记录新的请求路径
    LinearLayoutManager layoutManager;
    int refreshTime = 0;//记录刷新次数
    int flag1 = 0;//标记刷新次数



    public void setUrl(String url) {
        this.path = url;
        loadData(path);
    }

    public OverseasShoppingBoutiqueFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        path = bundle.getString("address");
    }
    @Override
    public void lazyLoad() {
        if (!isPrepared||!isVisible){
            return;
        }
        //网络数据加载
        loadData(path);
    }

    public void loadData(String path){
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(path);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_overseas_shopping_boutique, container, false);
        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.oversea_swipeRefresh);
        mRecycler = (RecyclerView) view.findViewById(R.id.oversea_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        isPrepared = true;
        lazyLoad();

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefresh.setColorSchemeResources(R.color.orange);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lazyLoad();
                        refreshAdapter.notifyDataSetChanged();

                        //将下拉进度收起
                        mSwipeRefresh.setRefreshing(false);
                    }
                },1000);
            }
        });

        mRecycler.addOnScrollListener(new OnRecyclerScrollListener());
        return view;
    }

    public class OnRecyclerScrollListener extends RecyclerView.OnScrollListener{
        int lastVisibleItem = 0;
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (refreshAdapter!=null&&newState==RecyclerView.SCROLL_STATE_IDLE&&
                    lastVisibleItem+1==refreshAdapter.getItemCount()){
                //滚动到底部了,可以进行数据加载等操作
                String url = null ;
                refreshTime+=1;
                if(refreshTime==1){
                    url = path;
                }else{
                    if(newPath!=null){
                        url = newPath;
                    }
                }
                int pageNo = refreshTime+1;
                String[] array = url.split("&");
                array[3]="p="+pageNo;
                int count = array.length;
                StringBuffer buffer = new StringBuffer();
                for(int i = 0;i<count-1;i++){
                    buffer.append(array[i]).append("&");
                }
                buffer.append(array[count-1]);
                newPath = buffer.toString();

                HttpUtils.getInstance().getDataFromNetWork(newPath);
                HttpUtils.getInstance().setDataCallBack(new DataCallBack() {
                    @Override
                    public void getDataCallBack(final String data) {
                        refreshAdapter.showLoading();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                AllListViewInfo allListViewInfo = new Gson().fromJson(data,AllListViewInfo.class);
                                List<AllListViewInfo.DataBean.LinklistBean> beanList = allListViewInfo.getData().getLinklist();
                                refreshAdapter.addDataAll(beanList);
                                refreshAdapter.refreshCompleted();
                                flag1+=1;
                            }
                        },1000);
                    }
                });
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            if(flag1>=1){
                lastVisibleItem+=1;
            }
        }
    }

    @Override
    public void getDataCallBack(String data) {
        AllListViewInfo allHotListViewInfo = new Gson().fromJson(data,AllListViewInfo.class);
        List<AllListViewInfo.DataBean.LinklistBean> hotBean = allHotListViewInfo.getData().getLinklist();
        refreshAdapter = new AllRefreshListViewAdapter(hotBean,getActivity());
        mRecycler.setAdapter(refreshAdapter);
        refreshAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                if (refreshAdapter.getList().get(position).getIsabroad() == 1){
                    Intent intent = new Intent(getActivity(),AllListHaiDetailActivity.class);
                    intent.putExtra("id",refreshAdapter.getList().get(position).getId());
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(),AllListGuoDetailActivity.class);
                    intent.putExtra("id",refreshAdapter.getList().get(position).getId());
                    getActivity().startActivity(intent);
                }
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });

    }

}