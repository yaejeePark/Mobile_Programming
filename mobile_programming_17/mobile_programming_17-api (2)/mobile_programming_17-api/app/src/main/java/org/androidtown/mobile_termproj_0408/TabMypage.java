package org.androidtown.mobile_termproj_0408;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sang on 2017-04-08.
 */

public class TabMypage extends Fragment {

    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_mypage, container, false);

        return rootView;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    //MypageAnalysis mypageAnalysis = new MypageAnalysis();
                    //return mypageAnalysis;

                case 1:
                 //   MypageReadBook readBookList = new MypageReadBook();
                   // return readBookList;

                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "analysis";
                case 1:
                    return "read book list";
            }
            return null;
        }
    }

}

