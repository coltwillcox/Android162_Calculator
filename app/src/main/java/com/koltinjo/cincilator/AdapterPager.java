package com.koltinjo.cincilator;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by colt on 02.12.2016.
 */

public class AdapterPager extends FragmentStatePagerAdapter {

    private FragmentInputSimple fragmentInputSimple;
    private FragmentInputSci fragmentInputSci;
    private Presenter presenter;

    public AdapterPager(FragmentManager fm, Presenter presenter) {
        super(fm);
        this.presenter = presenter;
        fragmentInputSimple = new FragmentInputSimple();
        fragmentInputSci = new FragmentInputSci();
        fragmentInputSimple.setPresenter(this.presenter);
        fragmentInputSci.setPresenter(this.presenter);
    }

    @Override
    public float getPageWidth(int position) {
        return App.getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ? 1f : position == 0 ? .57f : .43f;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragmentInputSimple;
            case 1:
                return fragmentInputSci;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

}