package org.androidtown.mobile_termproj_0408;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import org.androidtown.mobile_termproj_0408.R;

//import org.androidtown.mobile_termproj_0408.R;

public class MyPageReadBook extends Fragment {
    public static MyPageReadBook newInstance(){
        return new MyPageReadBook();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fv = inflater.inflate(R.layout.fragment_my_page_read_book, container, false);

        return fv;
    }
}