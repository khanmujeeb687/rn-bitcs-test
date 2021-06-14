package com.rnslider.slider_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.rnslider.R;


public class VideoViewFragmentTemp extends Fragment {

    private String reactVideoData;
    private Activity activity;
    private ImageView thumbnailView,playPause;
    private int index;
    private TextView textView;



    private static final String TAG = VideoViewFragmentTemp.class.getSimpleName();


    public VideoViewFragmentTemp(String videoUrl, int index) {
        this.reactVideoData=videoUrl;
        this.index=index;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        this.activity = getActivity();

        textView = view.findViewById(R.id.counter);
        textView.setBackgroundColor(0xFF42A5F5);
        textView.setText(""+index);
        return view;

    }

}
