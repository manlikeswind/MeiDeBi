package com.sunshine.cl.meidebi.fragment;

import android.content.Intent;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sunshine.cl.meidebi.activity.EditDescriptionActivity;
import com.sunshine.cl.meidebi.activity.ShowDetailActivity;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.ShowListAdapter;
import com.sunshine.cl.meidebi.bean.ShowInfo;
import com.sunshine.cl.meidebi.callback.DataCallBack;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;
import com.sunshine.cl.meidebi.utils.HttpUtils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment implements DataCallBack{

    SwipeRefreshLayout mRefresh;
    RecyclerView mRecycler;
    FloatingActionButton mFloatButton;
    RadioButton mHot;
    RadioButton mNew;
    RadioGroup mGroup;
    ShowListAdapter mAdapter;
    String hotPath = Constants.SHOW.SHOW_HOT;//默认加载精华
    String newestPath = Constants.SHOW.SHOW_NEW;//最新部分的路径
    LinearLayoutManager layoutManager;

    int refreshTime = 0;//记录刷新次数
    String newPath;//记录新的请求路径
    int flag1 = 0;//标记刷新次数


    public ShowFragment() {
        // Required empty public constructor
    }


    public void loadData(String path){
        HttpUtils.getInstance().setDataCallBack(this);
        HttpUtils.getInstance().getDataFromNetWork(path);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        mRefresh = (SwipeRefreshLayout) view.findViewById(R.id.show_refresh);
        mRecycler = (RecyclerView) view.findViewById(R.id.show_recycler);
        mGroup = (RadioGroup) view.findViewById(R.id.rd_group);
        mHot = (RadioButton) view.findViewById(R.id.show_essence);
        mNew = (RadioButton) view.findViewById(R.id.show_newest);
        mFloatButton = (FloatingActionButton) view.findViewById(R.id.show_float_button);
        loadData(hotPath);

        //悬浮按钮的点击事件
        mFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditDescriptionActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });


        //切换最新和精华
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.show_essence:
                        loadData(hotPath);
                        break;
                    case R.id.show_newest:
                        loadData(newestPath);
                        break;
                }
            }
        });

        layoutManager = new LinearLayoutManager(getActivity());
        mFloatButton = (FloatingActionButton) view.findViewById(R.id.show_float_button);
        mRecycler.setLayoutManager(layoutManager);
        mRefresh.setColorSchemeResources(R.color.orange);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(mHot.isChecked()){
                            loadData(hotPath);
                            //将下拉进度收起
                            mRefresh.setRefreshing(false);
                        }else if(mNew.isChecked()){
                            loadData(newestPath);
                            //将下拉进度收起
                            mRefresh.setRefreshing(false);
                        }
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
            if (mAdapter!=null&&newState==RecyclerView.SCROLL_STATE_IDLE&&
                    lastVisibleItem+1==mAdapter.getItemCount()){
                //滚动到底部了,可以进行数据加载等操作
                String url = null ;
                refreshTime+=1;

                if(mHot.isChecked()){
                    if(refreshTime==1){
                        url = hotPath;
                    }else{
                        if(newPath!=null){
                            url = newPath;
                        }
                    }
                }else if(mNew.isChecked()){
                    if(refreshTime==1){
                        url = newestPath;
                    }else{
                        if(newPath!=null){
                            url = newPath;
                        }
                    }
                }
                int pageNo = refreshTime+1;
                String[] array = url.split("&");
                array[2]="p="+pageNo;
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
                        mAdapter.showLoading();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ShowInfo showInfo = new Gson().fromJson(data,ShowInfo.class);
                                List<ShowInfo.DataBean.LinklistBean> beanList = showInfo.getData().getLinklist();
                                mAdapter.addDataAll(beanList);
                                mAdapter.refreshCompleted();
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
            //解决滑动冲突
            mRefresh.setEnabled(layoutManager.findFirstVisibleItemPosition()==0);
            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            if(flag1>=1){
                lastVisibleItem+=1;
            }
        }
    }

    @Override
    public void getDataCallBack(String data) {
        ShowInfo showInfo = new Gson().fromJson(data,ShowInfo.class);
        List<ShowInfo.DataBean.LinklistBean> beanList = showInfo.getData().getLinklist();
        mAdapter = new ShowListAdapter(beanList,getActivity());
        mRecycler.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                //设置点击事件
                Intent intent = new Intent(getActivity(), ShowDetailActivity.class);
                intent.putExtra("id",mAdapter.getList().get(position).getId());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
    }
}
