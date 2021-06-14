package com.rnslider.slider_app;

import android.view.Choreographer;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class ReactViewPagerManager extends SimpleViewManager<VideoScrollViewTemp> {

    public static final String REACT_CLASS = "ReactViewPager";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public @Nullable
    Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        builder.put("onVideoChange", MapBuilder.of("registrationName", "onVideoChange"));
        builder.put("onEndReached", MapBuilder.of("registrationName", "onEndReached"));
        return builder.build();
    }


    @Override
    protected VideoScrollViewTemp createViewInstance(ThemedReactContext reactContext) {
        return new VideoScrollViewTemp(reactContext.getCurrentActivity());
    }

    @Override
    public void onDropViewInstance(@NonNull VideoScrollViewTemp view) {
        super.onDropViewInstance(view);
//        view.drop();
    }

    @ReactProp(name = "urls")
    public void setUrls(VideoScrollViewTemp view, @Nullable ReadableMap urls) {
//        view.setUrl(urls);
    }


    @ReactProp(name = "initialPosition",defaultInt = 0)
    public void setInitialPosition(VideoScrollViewTemp view, int initialPosition) {
//        view.VideoScrollViewTemp(initialPosition);
    }

    @ReactProp(name = "type")
    public void setType(VideoScrollViewTemp view, String type) {
//        view.setType(type);
    }



    @ReactProp(name = "pause",defaultBoolean = false)
    public void setPause(VideoScrollViewTemp view, Boolean pause) {
//        view.changePause(pause);
    }

    @ReactProp(name = "uuid",defaultBoolean = false)
    public void setUUID(VideoScrollViewTemp view, String uuid) {
//        view.setUUID(uuid);
    }



}