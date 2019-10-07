package com.example.loltochess;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.loltochess.Fragment.FirstFragment;
import com.example.loltochess.Fragment.SecondFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;


    public ContentsPagerAdapter(final FragmentManager fm, final int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {

            case 0: {
                FirstFragment firstFragment = new FirstFragment();
                return firstFragment;

            }
            case 1: {
                SecondFragment secondFragment = new SecondFragment();
                return secondFragment;
            }

            default: {
                return null;
            }

        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
