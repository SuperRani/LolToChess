package com.example.loltochess.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.loltochess.Fragment.DamageFragment;

import com.example.loltochess.Fragment.GoldFragment;
import com.example.loltochess.Fragment.ReloadFragment;
import com.example.loltochess.Fragment.RoundFragment;


public class GuideAdapter extends FragmentStatePagerAdapter {
    protected int mPageCount;

    public GuideAdapter(@NonNull final FragmentManager fm, final int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }


    @Override
    public Fragment getItem(final int position) {
        switch (position) {

            case 0: {
                ReloadFragment reloadFragment = new ReloadFragment();
                return reloadFragment;
            }
            case 1: {
                RoundFragment roundFragment = new RoundFragment();
                return roundFragment;
            }
            case 2: {
                GoldFragment goldFragment = new GoldFragment();
                return goldFragment;
            }
            case 3: {
                DamageFragment damageFragment = new DamageFragment();
                return damageFragment;
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
