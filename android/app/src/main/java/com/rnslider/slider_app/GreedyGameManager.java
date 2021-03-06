package com.rnslider.slider_app;

import android.content.Context;

import com.greedygame.core.AppConfig;
import com.greedygame.core.GreedyGameAds;
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener;

public class GreedyGameManager {
    public static boolean isPrefetched = false;
    public static boolean isSdkInitialized() {
        return GreedyGameAds.isSdkInitialized();
    }

    public static void init(Context context, GreedyGameAdsEventsListener listener) {
        if (isSdkInitialized())
            return;
        AppConfig appConfig = new AppConfig.Builder(context).withAppId("adId").build();
        GreedyGameAds.initWith(appConfig, listener);
    }
}
