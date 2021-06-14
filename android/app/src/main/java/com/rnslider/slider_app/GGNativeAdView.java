package com.rnslider.slider_app;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.greedygame.core.adview.GGAdview;
import com.greedygame.core.adview.interfaces.AdLoadCallback;
import com.greedygame.core.adview.modals.AdRequestErrors;
import com.rnslider.R;

import org.jetbrains.annotations.NotNull;

public class GGNativeAdView extends ConstraintLayout {

    Context context;
    public String unitId = "float-5781";

    public GGNativeAdView(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public GGNativeAdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public GGNativeAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public GGNativeAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ad_component, this);

        GGAdview ggAdview = findViewById(R.id.nativeAd);
        ggAdview.setUnitId(unitId);
        if (GreedyGameManager.isSdkInitialized() && !GreedyGameManager.isPrefetched) {
            loadAd(ggAdview);
        }
    }

    private void loadAd(GGAdview ggAdview) {
        ggAdview.loadAd(new AdLoadCallback() {
            @Override
            public void onAdLoaded() {
                Log.i("GGNativeAd", "Exit ad Loaded");
            }

            @Override
            public void onAdLoadFailed(@NotNull AdRequestErrors adRequestErrors) {
                Log.i("GGNativeAd", "Exit ad Load Failed");
            }

            @Override
            public void onUiiOpened() {
                Log.i("GGNativeAd", "Exit ad Uii Opened");
            }

            @Override
            public void onUiiClosed() {
                Log.i("GGNativeAd", "Exit ad Uii Closed");
            }

            @Override
            public void onReadyForRefresh() {
                Log.i("GGNativeAd", "Exit ad Ready for refresh");
            }
        });
    }
}
