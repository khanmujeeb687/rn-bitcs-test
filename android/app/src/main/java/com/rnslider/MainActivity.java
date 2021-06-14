package com.rnslider;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.greedygame.core.interfaces.GreedyGameAdsEventsListener;
import com.greedygame.core.models.InitErrors;
import com.rnslider.slider_app.GreedyGameManager;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends ReactActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    initGGAd(this);
  }


  private static void initGGAd(Context context) {
    GreedyGameManager.init(context, new GreedyGameAdsEventsListener() {
      @Override
      public void onDestroyed() {
        Log.i("GGNativeAd",  "SDK Destroyed");
      }

      @Override
      public void onInitFailed(@NotNull InitErrors initErrors) {
        Log.i("GGNativeAd",  "SDK Failed");
      }

      @Override
      public void onInitSuccess() {
        Log.i("GGNativeAd",  "Init Successful");
      }
    });
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */


  @Override
  protected String getMainComponentName() {
    return "RnSlider";
  }
}
