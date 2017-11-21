package me.unmsm.alejandriapp.presentacion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.unmsm.alejandriapp.presentacion.Fragments.BooksFragment;
import me.unmsm.alejandriapp.presentacion.Fragments.HistoryFragment;
import me.unmsm.alejandriapp.presentacion.Fragments.ProfileFragment;


public class PagerAdapter extends FragmentPagerAdapter {
    private int numberOfTabs;


    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BooksFragment();
            case 1:
               return new HistoryFragment();
            case 2:
                return  new ProfileFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
