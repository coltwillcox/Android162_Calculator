package com.koltinjo.cincilator;

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