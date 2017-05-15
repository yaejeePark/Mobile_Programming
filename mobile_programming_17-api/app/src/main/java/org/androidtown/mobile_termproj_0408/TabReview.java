package org.androidtown.mobile_termproj_0408;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sang on 2017-04-08.
 */

public class TabReview extends Fragment {

    Button button;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_review, container, false);

        button=(Button)rootView.findViewById(R.id.add);

        //db 불러오기!!

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity) getActivity();
                activity.onActivityChanged(0);
            }
        });

        return rootView;
    }

}