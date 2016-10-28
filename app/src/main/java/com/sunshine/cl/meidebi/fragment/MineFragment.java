package com.sunshine.cl.meidebi.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import android.widget.Button;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.AppRecommendActivity;
import com.sunshine.cl.meidebi.activity.BindActivity;
import com.sunshine.cl.meidebi.activity.LoginActivity;
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

    TextView tv_login;
    TextView my_name;
    TextView my_copper;
    TextView my_score;
    Button my_sign;
    Button my_unLogin;

    SharedPreferences.Editor editor;
    SharedPreferences sp;
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

        tv_login = (TextView)view.findViewById(R.id.my_login);
        my_name = (TextView)view.findViewById(R.id.my_name);
        my_copper = (TextView)view.findViewById(R.id.my_copper);
        my_score = (TextView)view.findViewById(R.id.my_score);
        my_sign = (Button)view.findViewById(R.id.my_sign);
        my_unLogin = (Button)view.findViewById(R.id.my_unLogin);


        gridView.setAdapter(new MyGridViewAdapter(imgs,title,getActivity()));
        View view1 = gridView.getAdapter().getView(1,null,gridView);
        view1.measure(0,0);
        int totalHight = (view1.getMeasuredHeight()+1)*2;
        gridView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,totalHight));
        Random random = new Random();
        my_ram.setText("总计:"+String.valueOf(random.nextInt(40)));

        saveLogin();
        setOnClick();

        return view;
    }

    public void saveLogin(){
        sp = getActivity().getSharedPreferences("me", Context.MODE_PRIVATE);
        editor = sp.edit();
        if (sp.getInt("status",0) != 1){
            editor.putInt("status",0);
        }
        if (sp.getInt("status",0) == 1){
            tv_login.setVisibility(View.GONE);
            my_name.setText(sp.getString("name",""));
            my_copper.setText("铜币:0");
            my_score.setText("积分:0");
            my_sign.setText("已连续签到0天");
            my_name.setVisibility(View.VISIBLE);
            my_copper.setVisibility(View.VISIBLE);
            my_score.setVisibility(View.VISIBLE);
            my_sign.setVisibility(View.VISIBLE);
            my_unLogin.setVisibility(View.VISIBLE);
            my_sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    my_sign.setText("已连续签到1天");
                    my_copper.setText("铜币:2");
                    my_score.setText("积分:1");
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("签到成功,铜币+2,积分+1");
                    builder.create().show();
                }
            });
            my_unLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_login.setVisibility(View.VISIBLE);
                    my_name.setVisibility(View.GONE);
                    my_copper.setVisibility(View.GONE);
                    my_score.setVisibility(View.GONE);
                    my_sign.setVisibility(View.GONE);
                    my_unLogin.setVisibility(View.GONE);
                    editor.putInt("status",0);
                }
            });
        }
        editor.commit();
    }


    public void setOnClick(){
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
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
                my_ram.setText("总计:31.0Byte");
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
                if (sp.getInt("status",0) != 1){
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().overridePendingTransition(R.anim.in,0);
                }else {
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
            }
        });
    }

}
