package com.sunshine.cl.meidebi.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.adapter.FavorableViewPagerAdapter;
import com.sunshine.cl.meidebi.fragment.DomesticPreferenceFragment;
import com.sunshine.cl.meidebi.fragment.OverseasShoppingBoutiqueFragment;
import com.sunshine.cl.meidebi.fragment.SearchTradeAllFragment;
import com.sunshine.cl.meidebi.fragment.TmallDiscountFragment;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TradeClassDetailActivity extends AppCompatActivity {

    TabLayout mTab;
    ViewPager mViewPager;
    ImageView mBack;
    TextView mTitle;
    FragmentManager manager;
    RadioGroup mGroup;
    RadioButton mHot;
    RadioButton mNew;

    //精华
    String hotBaseUrl = "http://a.meidebi.com/new.php/Share-allhotlist?version=3.2.3";//精华的前半部分地址
    String hotJing = "devicetoken=352284040670808&limit=20&p=1&type=jing&devicetype=2";
    String hotGuo = "devicetoken=352284040670808&limit=20&p=1&type=guo&devicetype=2";//精华的国内优惠地址
    String hotHai = "devicetoken=352284040670808&limit=20&p=1&type=hai&devicetype=2";
    String hotTian = "devicetoken=352284040670808&limit=20&p=1&type=tian&devicetype=2";

    //最新
    String newBaseUrl = "http://a.meidebi.com/new.php/Share-alllist?version=3.2.3";//最新的前半部分地址
    String newJing = "devicetoken=352284040670808&limit=20&p=1&type=jing&devicetype=2";
    String newGuo = "devicetoken=352284040670808&limit=20&p=1&type=guo&devicetype=2";
    String newHai = "devicetoken=352284040670808&limit=20&p=1&type=hai&devicetype=2";
    String newTian = "devicetoken=352284040670808&limit=20&p=1&type=tian&devicetype=2";


    //转换后的地址
    String HOT_ALL;
    String HOT_GUO;
    String HOT_HAI;
    String HOT_TIAN;

    String NEW_ALL;
    String NEW_GUO;
    String NEW_HAI;
    String NEW_TIAN;

    String name;
    String id;

    SearchTradeAllFragment allFragment;
    DomesticPreferenceFragment domesticPreferenceFragment;
    OverseasShoppingBoutiqueFragment overseasShoppingBoutiqueFragment;
    TmallDiscountFragment tmallDiscountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_class_detail);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        //地址转换
        urlHandler();
        initViews();
        initFragment();
        addFirstData();
    }

    public void initViews() {
        mBack = (ImageView) findViewById(R.id.search_trade_con_back);
        mTitle = (TextView) findViewById(R.id.search_trade_con_title);
        mTab = (TabLayout) findViewById(R.id.search_trade_con_tab);
        mViewPager = (ViewPager) findViewById(R.id.search_trade_con_vp_replace);
        mGroup = (RadioGroup) findViewById(R.id.search_trade_con_radioGroup);
        mHot = (RadioButton) findViewById(R.id.search_trade_con_essence);
        mNew = (RadioButton) findViewById(R.id.search_hot_con_newest);
        manager = getSupportFragmentManager();

        //返回
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,R.anim.out);
            }
        });
        //设置标题
        mTitle.setText(name);

        //设置精华和最新的点击切换
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.search_trade_con_essence:
                        switch (mViewPager.getCurrentItem()) {
                            case 0:
                                allFragment.setUrl(HOT_ALL);
                                break;
                            case 1:
                                domesticPreferenceFragment.setUrl(HOT_GUO);
                                break;
                            case 2:
                                overseasShoppingBoutiqueFragment.setUrl(HOT_HAI);
                                break;
                            case 3:
                                tmallDiscountFragment.setUrl(HOT_TIAN);
                                break;
                        }
                        break;
                    case R.id.search_hot_con_newest:
                        switch (mViewPager.getCurrentItem()) {
                            case 0:
                                allFragment.setUrl(NEW_ALL);
                                break;
                            case 1:
                                domesticPreferenceFragment.setUrl(NEW_GUO);
                                break;
                            case 2:
                                overseasShoppingBoutiqueFragment.setUrl(NEW_HAI);
                                break;
                            case 3:
                                tmallDiscountFragment.setUrl(NEW_TIAN);
                                break;
                        }
                        break;
                }
            }
        });

        //ViewPager的滑动监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        if (mHot.isChecked()) {
                            allFragment.setUrl(HOT_ALL);
                        } else if (mNew.isChecked()) {
                            allFragment.setUrl(NEW_ALL);
                        }
                        break;
                    case 1:
                        if (mHot.isChecked()) {
                            domesticPreferenceFragment.setUrl(HOT_GUO);
                        } else if (mNew.isChecked()) {
                            domesticPreferenceFragment.setUrl(NEW_GUO);
                        }
                        break;
                    case 2:
                        if (mHot.isChecked()) {
                            overseasShoppingBoutiqueFragment.setUrl(HOT_HAI);
                        } else if (mNew.isChecked()) {
                            overseasShoppingBoutiqueFragment.setUrl(NEW_HAI);
                        }
                        break;
                    case 3:
                        if (mHot.isChecked()) {
                            tmallDiscountFragment.setUrl(HOT_TIAN);
                        } else if (mNew.isChecked()) {
                            tmallDiscountFragment.setUrl(NEW_TIAN);
                        }
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    public void urlHandler() {
        HOT_ALL = hotBaseUrl + "&" + id + "&" + hotJing;
        HOT_GUO = hotBaseUrl + "&" + id + "&" + hotGuo;
        HOT_HAI = hotBaseUrl + "&" + id + "&" + hotHai;
        HOT_TIAN = hotBaseUrl + "&" + id + "&" + hotTian;

        NEW_ALL = newBaseUrl + "&" + id + "&" + newJing;
        NEW_GUO = newBaseUrl + "&" + id + "&" + newGuo;
        NEW_HAI = newBaseUrl + "&" + id + "&" + newHai;
        NEW_TIAN = newBaseUrl + "&" + id + "&" + newTian;

    }

    public void initFragment() {
        allFragment = new SearchTradeAllFragment();
        domesticPreferenceFragment = new DomesticPreferenceFragment();
        overseasShoppingBoutiqueFragment = new OverseasShoppingBoutiqueFragment();
        tmallDiscountFragment = new TmallDiscountFragment();
    }

    /**
     * 默认加载精华部分
     */
    public void addFirstData() {
        List<String> titleList = new ArrayList<>();
        titleList.add(getResources().getString(R.string.tab_all));
        titleList.add(getResources().getString(R.string.tab_domestic));
        titleList.add(getResources().getString(R.string.tab_essence));
        titleList.add(getResources().getString(R.string.tab_tmall));

        List<Fragment> fragmentList = new ArrayList<>();

        //全部
        Bundle bundleAll = new Bundle();
        bundleAll.putString("address", HOT_ALL);
        allFragment.setArguments(bundleAll);
        fragmentList.add(allFragment);

        //国内
        Bundle bundleDomestic = new Bundle();
        bundleDomestic.putString("address", HOT_GUO);
        domesticPreferenceFragment.setArguments(bundleDomestic);
        fragmentList.add(domesticPreferenceFragment);

        //海淘
        Bundle bundleOversea = new Bundle();
        bundleOversea.putString("address", HOT_HAI);
        overseasShoppingBoutiqueFragment.setArguments(bundleOversea);
        fragmentList.add(overseasShoppingBoutiqueFragment);
        //天猫
        Bundle bundleTmall = new Bundle();
        bundleTmall.putString("address", HOT_TIAN);
        tmallDiscountFragment.setArguments(bundleTmall);
        fragmentList.add(tmallDiscountFragment);

        mViewPager.setAdapter(new FavorableViewPagerAdapter(manager, fragmentList, titleList));
        mTab.setupWithViewPager(mViewPager);
        mTab.setTabMode(TabLayout.MODE_FIXED);
        mTab.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorIndicator));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0,R.anim.out);
    }
}


