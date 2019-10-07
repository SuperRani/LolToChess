package com.example.loltochess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class SynergyActivity extends AppCompatActivity {

    public ViewPager mVp;
    public ContentsPagerAdapter mContentsPagerAdapter;
    public TabLayout mTabLayout;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synergy);
        mContext = getApplicationContext();

        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);
        mTabLayout.addTab(mTabLayout.newTab().setText("종족 시너지"));
        mTabLayout.addTab(mTabLayout.newTab().setText("직업 시너지"));

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mVp = (ViewPager) findViewById(R.id.vp);

        mContentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mVp.setAdapter(mContentsPagerAdapter);

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
