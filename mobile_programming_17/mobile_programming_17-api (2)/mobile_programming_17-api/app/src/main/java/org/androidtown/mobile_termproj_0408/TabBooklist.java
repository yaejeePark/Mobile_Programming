package org.androidtown.mobile_termproj_0408;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by sang on 2017-04-08.
 */

public class TabBooklist extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_booklist, container, false);
        return rootView;

        //Button mybutton=(Button)findViewById(R.id.button2);


    }

}
