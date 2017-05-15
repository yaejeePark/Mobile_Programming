package org.androidtown.mobile_termproj_0408;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import org.androidtown.mobile_termproj_0408.R;

public class MyPageAnylysis extends Fragment {
    public static MyPageAnylysis newInstance(){
        return new MyPageAnylysis();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fv = inflater.inflate(R.layout.fragment_mypage_anylysis, container, false);

        return fv;
    }
}