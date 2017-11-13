package me.unmsm.alejandriapp.presentacion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.unmsm.alejandriapp.presentacion.Fragments.BooksFragment;
import me.unmsm.alejandriapp.presentacion.Fragments.HistoryFragment;
import me.unmsm.alejandriapp.presentacion.Fragments.ProfileFragment;


/**
 * Created by KERLY on 15/10/2017.
 */

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
                BooksFragment booksFragment =new BooksFragment();
                return booksFragment;
            case 1:
                HistoryFragment historyFragment =new HistoryFragment();
                return historyFragment;
            case 2:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
