package com.rnslider.slider_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.rnslider.R;

public class GreedyGameFragment extends Fragment {


    private int index;
    private String reactVideoData;


    private static final String TAG = VideoViewFragmentTemp.class.getSimpleName();


    public GreedyGameFragment(int index, String reactVideoData) {
        this.index = index;
        this.reactVideoData=reactVideoData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_greedy_game, container, false);
    }


}
