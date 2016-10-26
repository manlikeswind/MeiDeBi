package com.sunshine.cl.meidebi.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.FavorableViewPagerAdapter;
import com.sunshine.cl.meidebi.fragment.MyCollectConversionFragment;
import com.sunshine.cl.meidebi.fragment.MyCollectFavorableFragment;
import com.sunshine.cl.meidebi.fragment.MyCollectShowFragment;

import java.util.ArrayList;
import java.util.List;

public class MyCollectActivity extends AppCompatActivity {

    ImageView img_back;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect);
        img_back = (ImageView)findViewById(R.id.my_collect_back);
        viewPager = (ViewPager)findViewById(R.id.my_collect_viewPager);
        tabLayout = (TabLayout)findViewById(R.id.my_collect_tabLayout);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorIndicator));
        tabLayout.setupWithViewPager(viewPager);

        List<String> listTitle = new ArrayList<>();
        listTitle.add("优惠");
        listTitle.add("晒单");
        listTitle.add("领券");

        List<Fragment> list = new ArrayList<>();
        list.add(new MyCollectFavorableFragment());
        list.add(new MyCollectShowFragment());
        list.add(new MyCollectConversionFragment());

        viewPager.setAdapter(new FavorableViewPagerAdapter(getSupportFragmentManager(),list,listTitle));

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}
