package com.sunshine.cl.meidebi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.AppRecommendActivity;
import com.sunshine.cl.meidebi.activity.BindActivity;
import com.sunshine.cl.meidebi.activity.MyCollectActivity;
import com.sunshine.cl.meidebi.activity.MyCommentActivity;
import com.sunshine.cl.meidebi.activity.MyConversionActivity;
import com.sunshine.cl.meidebi.activity.MyExplodeActivity;
import com.sunshine.cl.meidebi.activity.MyMessageActivity;
import com.sunshine.cl.meidebi.activity.MyShowActivity;
import com.sunshine.cl.meidebi.activity.MyTaskActivity;
import com.sunshine.cl.meidebi.activity.PushActivity;
import com.sunshine.cl.meidebi.adapter.MyGridViewAdapter;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    GridView gridView;
    RelativeLayout my_bind;
    RelativeLayout my_task;
    RelativeLayout my_recommend;
    RelativeLayout my_push;
    RelativeLayout my_clear;
    TextView my_ram;
    TextView tv_wifi;
    CheckBox checkBox;


    int[] imgs = new int[]{R.mipmap.ic_user_msg,R.mipmap.ic_user_order_show,R.mipmap.ic_user_coupon,
            R.mipmap.ic_user_fav,R.mipmap.ico_message,R.mipmap.ico_comment};
    String[] title = new String[]{"我的爆料","我的晒单","我的优惠券","我的收藏","我的消息","我的评论"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        my_bind = (RelativeLayout)view.findViewById(R.id.my_bind);
        my_task = (RelativeLayout)view.findViewById(R.id.my_task);
        my_push = (RelativeLayout)view.findViewById(R.id.my_push);
        my_recommend = (RelativeLayout)view.findViewById(R.id.my_recommend);
        my_clear = (RelativeLayout)view.findViewById(R.id.my_clear);
        my_ram = (TextView)view.findViewById(R.id.my_ram);
        tv_wifi = (TextView)view.findViewById(R.id.my_wifi_switch);
        checkBox = (CheckBox)view.findViewById(R.id.my_checkBox);
        gridView = (GridView)view.findViewById(R.id.my_gridView);


        gridView.setAdapter(new MyGridViewAdapter(imgs,title,getActivity()));
        View view1 = gridView.getAdapter().getView(1,null,gridView);
        view1.measure(0,0);
        int totalHight = (view1.getMeasuredHeight()+1)*2;
        gridView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,totalHight));
        Random random = new Random();
        my_ram.setText(String.valueOf(random.nextInt(40)));

        setOnClick();

        return view;
    }

    public void setOnClick(){
        my_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BindActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        my_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyTaskActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        my_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AppRecommendActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        my_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_ram.setText("31.0Byte");
                Toast.makeText(getActivity(), "缓存已清空", Toast.LENGTH_SHORT).show();
            }
        });
        my_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PushActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tv_wifi.setText("打开");
                }else {
                    tv_wifi.setText("关闭");
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    startActivity(new Intent(getActivity(), MyExplodeActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
                if (position == 1){
                    startActivity(new Intent(getActivity(), MyShowActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
                if (position == 2){
                    startActivity(new Intent(getActivity(), MyConversionActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
                if (position == 3){
                    startActivity(new Intent(getActivity(), MyCollectActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
                if (position == 4){
                    startActivity(new Intent(getActivity(), MyMessageActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
                if (position == 5){
                    startActivity(new Intent(getActivity(), MyCommentActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }
            }
        });
    }

}
