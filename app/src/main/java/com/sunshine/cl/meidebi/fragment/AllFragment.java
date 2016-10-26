package com.sunshine.cl.meidebi.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.AllListGuoDetailActivity;
import com.sunshine.cl.meidebi.activity.AllListHaiDetailActivity;
import com.sunshine.cl.meidebi.activity.UnderAdActivity;
import com.sunshine.cl.meidebi.activity.WebLinkActivity;
import com.sunshine.cl.meidebi.adapter.AdViewPagerAdapter;
import com.sunshine.cl.meidebi.adapter.AllListViewAdapter;
import com.sunshine.cl.meidebi.bean.AdAutoInfo;
import com.sunshine.cl.meidebi.bean.AllListViewInfo;
import com.sunshine.cl.meidebi.callback.JsonCallBack;
import com.sunshine.cl.meidebi.callback.OnItemClickListener;
import com.sunshine.cl.meidebi.constants.Constants;
import com.sunshine.cl.meidebi.http.OKHttpGetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends BaseFragment implements JsonCallBack {

    boolean isPrepared = false;
    SwipeRefreshLayout srl;
    ListView listView;
    View headView;
    AutoScrollViewPager autoScrollViewPager;
    LinearLayout ad_llayout;
    ProgressBar progressBar;

    RelativeLayout relayout_haitao;
    RelativeLayout discount_look;
    RelativeLayout cabbage_price;
    AllListViewAdapter adapter;
    List<AllListViewInfo.DataBean.LinklistBean> list;
    boolean flag1 = true;
    int p = 1;
    String share = "allhotlist";
    String path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&type=jing&devicetype=2";

    public void setUrl(String url) {
        this.share = url;
        path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&type=jing&devicetype=2";
        setListViewData(path);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.allFragment_srl);
        listView = (ListView) view.findViewById(R.id.allFragment_listView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.head, null);
        autoScrollViewPager = (AutoScrollViewPager) headView.findViewById(R.id.autoScrollViewPager);
        ad_llayout = (LinearLayout) headView.findViewById(R.id.ad_llayout);
        relayout_haitao = (RelativeLayout) headView.findViewById(R.id.relayout_haitao);
        discount_look = (RelativeLayout) headView.findViewById(R.id.discount_look);
        cabbage_price = (RelativeLayout) headView.findViewById(R.id.cabbage_price);


        isPrepared = true;
        lazyLoad();
        listView.addHeaderView(headView);
        setOnClick();
        srl.setColorSchemeColors(getResources().getColor(R.color.colorRefreash));
        return view;
    }

    @Override
    public void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        getShopInfo(Constants.AD_AUTO);
        setListViewData(path);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setListViewData(path);
                srl.setRefreshing(false);
            }
        });
    }

    public void getShopInfo(String path1) {
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path1);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(AllFragment.this);
    }

    public void setListViewData(String path2) {
        OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path2);
        okHttpGetUtils.getJsonData();
        okHttpGetUtils.setCallBack(new JsonCallBack() {
            @Override
            public void getJsonCallBack(String str) {
                Gson gson = new Gson();
                AllListViewInfo info = gson.fromJson(str, AllListViewInfo.class);
                list = info.getData().getLinklist();
                adapter = new AllListViewAdapter(list, getActivity());
                listView.setAdapter(adapter);
            }
        });
    }

    public void operationView(final AdAutoInfo info) {
        List<View> list = new ArrayList<>();
        int size = info.getData().size();
        if (ad_llayout.getChildCount() != 0) {
            ad_llayout.removeAllViews();
        }
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getActivity()).load(info.getData().get(i).getImgurl()).config(Bitmap.Config.RGB_565).into(imageView);
            list.add(imageView);

            ImageView img_point = new ImageView(getActivity());
            img_point.setPadding(10, 0, 10, 0);
            if (i == 0) {
                img_point.setImageResource(R.drawable.point_select);
            } else {
                img_point.setImageResource(R.drawable.point_default);
            }
            ad_llayout.addView(img_point);
        }
        AdViewPagerAdapter adapter = new AdViewPagerAdapter(list);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(getActivity(), WebLinkActivity.class);
                intent.putExtra("link", info.getData().get(position).getLink());
                intent.putExtra("title", info.getData().get(position).getTitle());
                intent.putExtra("flag", 1);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in, 0);
            }
        });
        autoScrollViewPager.setAdapter(adapter);
        autoScrollViewPager.setCycle(true);
        autoScrollViewPager.setInterval(3000);
        autoScrollViewPager.startAutoScroll();
        autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                int count = ad_llayout.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView img = (ImageView) ad_llayout.getChildAt(i);
                    if (i == position) {
                        img.setImageResource(R.drawable.point_select);
                    } else {
                        img.setImageResource(R.drawable.point_default);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setOnClick() {
        relayout_haitao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UnderAdActivity.class);
                intent.putExtra("share","haitaodirect");
                intent.putExtra("flag",0);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        discount_look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UnderAdActivity.class);
                intent.putExtra("share","tmallcoupon");
                intent.putExtra("flag",1);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        cabbage_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UnderAdActivity.class);
                intent.putExtra("share","baicai");
                intent.putExtra("flag",2);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position--;
                if (list.get(position).getIsabroad() == 1){
                    Intent intent = new Intent(getActivity(),AllListHaiDetailActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(),AllListGuoDetailActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    getActivity().startActivity(intent);
                }
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case 0:
                        if (flag1) {
                            progressBar.setVisibility(View.VISIBLE);
                            progressBar.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setVisibility(View.GONE);
                                    p++;
                                    path = "http://a.meidebi.com/new.php/Share-" + share + "?version=3.2.3&devicetoken=352284040670808&limit=20&p=" + p + "&type=jing&devicetype=2";
                                    OKHttpGetUtils okHttpGetUtils = new OKHttpGetUtils(path);
                                    okHttpGetUtils.getJsonData();
                                    okHttpGetUtils.setCallBack(new JsonCallBack() {
                                        @Override
                                        public void getJsonCallBack(String str) {
                                            Gson gson = new Gson();
                                            AllListViewInfo info = gson.fromJson(str, AllListViewInfo.class);
                                            List<AllListViewInfo.DataBean.LinklistBean> list1 = info.getData().getLinklist();
                                            list.addAll(list1);
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                            }, 1000);
                        }
                        break;
                    case 1:
//                        if (flag1) {
//                            progressBar.setVisibility(View.VISIBLE);
//                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if ((firstVisibleItem + visibleItemCount) == totalItemCount) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
                if (firstVisibleItem == 0) {
                    srl.setEnabled(true);
                }else {
                    srl.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void getJsonCallBack(String str) {
        Gson gson = new Gson();
        AdAutoInfo info = gson.fromJson(str, AdAutoInfo.class);
        operationView(info);
    }
}
