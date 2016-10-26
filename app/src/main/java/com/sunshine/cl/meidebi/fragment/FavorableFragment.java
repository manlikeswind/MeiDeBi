package com.sunshine.cl.meidebi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.sunshine.cl.meidebi.R;
import com.sunshine.cl.meidebi.activity.SearchActivity;
import com.sunshine.cl.meidebi.adapter.FavorableViewPagerAdapter;
import com.sunshine.cl.meidebi.constants.Constants;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavorableFragment extends Fragment {

    FragmentManager manager;
    TabLayout mFavorableTab;
    ViewPager mFavorableView;
    List<String> titleName;
    ImageView mSearchIcon;
    RadioGroup mGroup;
    RadioButton mHot;
    RadioButton mNew;
    //精华
    AllFragment allFragment;
    DomesticPreferenceFragment domesticPreferenceFragment;
    OverseasShoppingBoutiqueFragment overseasShoppingBoutiqueFragment;
    TmallDiscountFragment tmallDiscountFragment;

    public FavorableFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorable, container, false);
        manager = getFragmentManager();
        initData(view);
        return view;
    }

    public void initData(View view) {
        mFavorableView = (ViewPager) view.findViewById(R.id.favorable_vp_replace);
        mFavorableTab = (TabLayout) view.findViewById(R.id.favorable_tab);
        mSearchIcon = (ImageView) view.findViewById(R.id.search_icon);
        mGroup = (RadioGroup) view.findViewById(R.id.rd_group);
        mHot = (RadioButton) view.findViewById(R.id.favorable_essence);
        mNew = (RadioButton) view.findViewById(R.id.favorable_newest);

        titleName = new ArrayList<>();
        titleName.add(getResources().getString(R.string.tab_all));
        titleName.add(getResources().getString(R.string.tab_domestic));
        titleName.add(getResources().getString(R.string.tab_essence));
        titleName.add(getResources().getString(R.string.tab_tmall));

        initFragment();//初始化frgament
        //默认加载精华
        addFirstFragment();

        //切换监听
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.favorable_essence:
                        switch (mFavorableView.getCurrentItem()) {
                            case 0:
                                allFragment.setUrl("allhotlist");
                                break;
                            case 1:
                                domesticPreferenceFragment.setUrl(Constants.DOMESTIC.DOMESTIC_HOT);
                                break;
                            case 2:
                                overseasShoppingBoutiqueFragment.setUrl(Constants.OVERSEA.OVERSEA_HOT);
                                break;
                            case 3:
                                tmallDiscountFragment.setUrl(Constants.TMALL.TMALL_HOT);
                                break;
                        }
                        break;
                    case R.id.favorable_newest:
                        switch (mFavorableView.getCurrentItem()) {
                            case 0:
                                allFragment.setUrl("alllist");
                                break;
                            case 1:
                                domesticPreferenceFragment.setUrl(Constants.DOMESTIC.DOMESTIC_NEWEST);
                                break;
                            case 2:
                                overseasShoppingBoutiqueFragment.setUrl(Constants.OVERSEA.OVERSEA_NEWEST);
                                break;
                            case 3:
                                tmallDiscountFragment.setUrl(Constants.TMALL.TMALL_NEWEST);
                                break;
                        }
                        break;
                }
            }
        });

        mFavorableView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        if (mHot.isChecked()){
                            allFragment.setUrl("allhotlist");
                        }else if(mNew.isChecked()){
                            allFragment.setUrl("alllist");
                        }
                        break;
                    case 1:
                        if (mHot.isChecked()) {
                            domesticPreferenceFragment.setUrl(Constants.DOMESTIC.DOMESTIC_HOT);
                        } else if (mNew.isChecked()) {
                            domesticPreferenceFragment.setUrl(Constants.DOMESTIC.DOMESTIC_NEWEST);
                        }
                        break;
                    case 2:
                        if (mHot.isChecked()) {
                            overseasShoppingBoutiqueFragment.setUrl(Constants.OVERSEA.OVERSEA_HOT);
                        } else if (mNew.isChecked()) {
                            overseasShoppingBoutiqueFragment.setUrl(Constants.OVERSEA.OVERSEA_NEWEST);
                        }
                        break;
                    case 3:
                        if (mHot.isChecked()) {
                            tmallDiscountFragment.setUrl(Constants.TMALL.TMALL_HOT);
                        } else if (mNew.isChecked()) {
                            tmallDiscountFragment.setUrl(Constants.TMALL.TMALL_NEWEST);
                        }
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mSearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
                getActivity().overridePendingTransition(R.anim.in,0);
            }
        });
    }


    public void initFragment() {
        allFragment = new AllFragment();
        domesticPreferenceFragment = new DomesticPreferenceFragment();
        overseasShoppingBoutiqueFragment = new OverseasShoppingBoutiqueFragment();
        tmallDiscountFragment = new TmallDiscountFragment();
    }

    public void addFirstFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        //默认加载精华部分
        fragmentList.add(allFragment);
        //国内优惠
        Bundle bundleDomestic = new Bundle();
        String DomesticPath = Constants.DOMESTIC.DOMESTIC_HOT;
        bundleDomestic.putString("address", DomesticPath);
        domesticPreferenceFragment.setArguments(bundleDomestic);
        fragmentList.add(domesticPreferenceFragment);
        //海淘精品
        Bundle bundleOversea = new Bundle();
        String overseaPath = Constants.OVERSEA.OVERSEA_HOT;
        bundleOversea.putString("address", overseaPath);
        overseasShoppingBoutiqueFragment.setArguments(bundleOversea);
        fragmentList.add(overseasShoppingBoutiqueFragment);
        //天猫折扣
        Bundle bundleTmall = new Bundle();
        String tmallPath = Constants.TMALL.TMALL_HOT;
        bundleTmall.putString("address", tmallPath);
        tmallDiscountFragment.setArguments(bundleTmall);
        fragmentList.add(tmallDiscountFragment);
        mFavorableView.setAdapter(new FavorableViewPagerAdapter(manager, fragmentList, titleName));
        mFavorableTab.setupWithViewPager(mFavorableView);
        mFavorableTab.setTabMode(TabLayout.MODE_FIXED);
        mFavorableTab.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorIndicator));
    }
}