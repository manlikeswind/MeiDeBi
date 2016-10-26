package com.sunshine.cl.meidebi.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.view.View;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.SearchViewPagerAdapter;
import com.sunshine.cl.meidebi.fragment.HotStoreFragment;
import com.sunshine.cl.meidebi.fragment.TradeClassFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    ImageView img_back;
    EditText editText;
    Button trade_class_btn;
    Button hot_store_btn;
    ViewPager viewPager;
    List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        img_back = (ImageView)findViewById(R.id.search_back);
        editText = (EditText)findViewById(R.id.search_editText);
        trade_class_btn = (Button)findViewById(R.id.trade_class_btn);
        hot_store_btn = (Button)findViewById(R.id.hot_store_btn);
        viewPager = (ViewPager)findViewById(R.id.search_viewPager);

        list = new ArrayList<>();
        list.add(new TradeClassFragment());
        list.add(new HotStoreFragment());
        viewPager.setAdapter(new SearchViewPagerAdapter(getSupportFragmentManager(),list));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    trade_class_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.search_btn1));
                    hot_store_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.search_btn22));
                    trade_class_btn.setTextColor(getResources().getColor(R.color.white));
                    hot_store_btn.setTextColor(getResources().getColor(R.color.black));
                }
                if (position == 1){
                    hot_store_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.search_btn2));
                    trade_class_btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.search_btn11));
                    hot_store_btn.setTextColor(getResources().getColor(R.color.white));
                    trade_class_btn.setTextColor(getResources().getColor(R.color.black));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
