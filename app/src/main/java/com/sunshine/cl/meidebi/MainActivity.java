package com.sunshine.cl.meidebi;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.sunshine.cl.meidebi.activity.DisplayActivity;
import com.sunshine.cl.meidebi.fragment.ConversionFragment;
import com.sunshine.cl.meidebi.fragment.FavorableFragment;
import com.sunshine.cl.meidebi.fragment.MineFragment;
import com.sunshine.cl.meidebi.fragment.ShowFragment;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageView img_baoliao;

    FavorableFragment favorableFragment;
    ShowFragment showFragment;
    ConversionFragment conversionFragment;
    MineFragment mineFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        img_baoliao = (ImageView)findViewById(R.id.baoliao);
        initFragment();
        img_baoliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
                overridePendingTransition(R.anim.in,0);
            }
        });
    }

    public void initFragment(){
        if (favorableFragment == null){
            favorableFragment = new FavorableFragment();
        }
        if (showFragment == null){
            showFragment = new ShowFragment();
        }
        if (conversionFragment == null){
            conversionFragment = new ConversionFragment();
        }
        if (mineFragment == null){
            mineFragment = new MineFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.relayout_home,favorableFragment);
        ft.add(R.id.relayout_home,showFragment).hide(showFragment);
        ft.add(R.id.relayout_home,conversionFragment).hide(conversionFragment);
        ft.add(R.id.relayout_home,mineFragment).hide(mineFragment);
        ft.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                ft1.hide(favorableFragment);
                ft1.hide(showFragment);
                ft1.hide(conversionFragment);
                ft1.hide(mineFragment);
                switch (checkedId){
                    case R.id.radioButton1:
                        ft1.show(favorableFragment);
                        break;
                    case R.id.radioButton2:
                        ft1.show(showFragment);
                        break;
                    case R.id.radioButton3:
                        ft1.show(conversionFragment);
                        break;
                    case R.id.radioButton4:
                        ft1.show(mineFragment);
                        break;
                }
                ft1.commit();
            }
        });
    }
}
