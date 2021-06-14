package com.rnslider.slider_app;

import android.app.Activity;
import android.graphics.Rect;
import android.view.Choreographer;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class VideoScrollViewTemp extends ViewGroup {
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<String> videoUrlList= new ArrayList<String>();
    private Activity activity;
    private ViewPager2 viewPager2Instance;
    private final Rect mTmpContainerRect = new Rect();
    private final Rect mTmpChildRect = new Rect();
    private int initialAdIndex=2;
    private int frequency=4;
    private Boolean isAdEnabled=true;



    private void fillUrls(){
        for(int i=0;i<=100;i++){
            videoUrlList.add(i+"");
        }
    }



    public VideoScrollViewTemp(Activity activity) {
        super(activity.getApplicationContext());
        setupLayoutHack();
        this.activity=activity;
        ViewPager2 viewPager = new ViewPager2(activity.getApplicationContext());
        viewPager2Instance=viewPager;
        viewPager2Instance.setLayoutParams(
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        fillUrls();
        pagerAdapter = new ScreenSlidePagerAdapter((FragmentActivity) activity,videoUrlList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager.setOffscreenPageLimit(2);
        attachViewToParent(viewPager,0,viewPager.getLayoutParams());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = viewPager2Instance.getMeasuredWidth();
        int height = viewPager2Instance.getMeasuredHeight();
        mTmpContainerRect.left = getPaddingLeft();
        mTmpContainerRect.right = r - l - getPaddingRight();
        mTmpContainerRect.top = getPaddingTop();
        mTmpContainerRect.bottom = b - t - getPaddingBottom();

        Gravity.apply(Gravity.TOP | Gravity.START, width, height, mTmpContainerRect, mTmpChildRect);
        viewPager2Instance.layout(mTmpChildRect.left, mTmpChildRect.top, mTmpChildRect.right,
                mTmpChildRect.bottom);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measureChild(viewPager2Instance, widthMeasureSpec, heightMeasureSpec);
        int width = viewPager2Instance.getMeasuredWidth();
        int height = viewPager2Instance.getMeasuredHeight();
        int childState = viewPager2Instance.getMeasuredState();

        width += getPaddingLeft() + getPaddingRight();
        height += getPaddingTop() + getPaddingBottom();

        width = Math.max(width, getSuggestedMinimumWidth());
        height = Math.max(height, getSuggestedMinimumHeight());

        setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, childState),
                resolveSizeAndState(height, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));
    }



    private Boolean isAd(int i) {
        return (i>=initialAdIndex && ((i==initialAdIndex) || (((i-initialAdIndex)%(frequency))==0)));
    }





    private class ScreenSlidePagerAdapter extends FragmentStateAdapter{
        private ArrayList<String> dataItems= new ArrayList<String>();

        public ScreenSlidePagerAdapter(FragmentActivity fa, ArrayList<String> data) {
            super(fa);
            this.dataItems=data;
        }

        @Override
        public Fragment createFragment(int position) {
            if(isAd(position)) return new GreedyGameFragment(position,dataItems.get(position));
            return new VideoViewFragmentTemp(dataItems.get(position),position);
        }

        @Override
        public int getItemCount() {return dataItems.size();}

    }


    void setupLayoutHack() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                manuallyLayoutChildren();
                getViewTreeObserver().dispatchOnGlobalLayout();
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }

    void manuallyLayoutChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), View.MeasureSpec.EXACTLY));
            child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
        }
    }


}
