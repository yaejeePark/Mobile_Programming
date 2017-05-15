package org.androidtown.mobile_termproj_0408;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by sang on 2017-04-08.
 */

public class TabMypage extends Fragment {

    private MainActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
@Override
public void onCreate(Bundle savedInstatceState){
    //startActivity(new Intent(this, SplashActivity.class));
    super.onCreate(savedInstatceState);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_mypage, container, false);
        TabLayout tabLayout = (TabLayout)rootView.findViewById(R.id.tabs);
                //findViewById(R.id.tabs);
       // tabLayout.setupWithViewPager(mViewPager);
        return rootView;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fg;
            switch (position) {
                case 0:
                    MyPageAnylysis tab1tree = new MyPageAnylysis();
                    return tab1tree;
                    //fg = MyPageAnylysis.newInstance();
//                   fg=MyPageAnylysis.newInstance();
//                    getChildFragmentManager();
                    //setChildFragment(fg);
                    //return mypageAnalysis;
//break;
                case 1:
                    MyPageReadBook tab1tree1 = new MyPageReadBook();
                    return tab1tree1;
//                    fg=MyPageReadBook.newInstance();
//                    getChildFragmentManager();                   // return readBookList;
                default:
                    return null;

            }
            //return null;
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
        private void setupTabLayout() {
            TabLayout mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
            mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    onTabTapped(tab.getPosition());
                }
                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }
                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                    onTabTapped(tab.getPosition());
                }
            });
        }

        private void onTabTapped(int position) {
            switch (position) {
                case 0:
                    // Do something when first tab is tapped here
                    break;
                case 1:
                    Toast.makeText(this, "Tapped " + position, Toast.LENGTH_SHORT);
                    // Do something when first tab is tapped here
                    break;
                default:
            }
        }
    }

}

