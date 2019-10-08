package com.example.loltochess.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.example.loltochess.Adapter.GuideAdapter;
import com.example.loltochess.R;
import com.google.android.material.tabs.TabLayout;

public class GuideActivity extends AppCompatActivity {
    public ViewPager mVp;
    public GuideAdapter mGuideAdapter;
    public TabLayout mTabLayout;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mContext = getApplicationContext();

        mTabLayout =  findViewById(R.id.layout_tab_guide);
        mTabLayout.addTab(mTabLayout.newTab().setText("리롤 확률"));
        mTabLayout.addTab(mTabLayout.newTab().setText("라운드 정보"));
        mTabLayout.addTab(mTabLayout.newTab().setText("골드"));
        mTabLayout.addTab(mTabLayout.newTab().setText("피해량 공식"));

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mVp = findViewById(R.id.vp_guide);

        mGuideAdapter = new GuideAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mVp.setAdapter(mGuideAdapter);

        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {  //탭 선택되었을 때 호출
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {    // 탭이 선택되지 않았을 대 호출

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {    // 탭이 다시 선택되었을 때 호출

            }
        });
    }
}
