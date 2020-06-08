package com.example.vidplay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyVerticalViewPager extends ViewPager {

    public MyVerticalViewPager(@NonNull Context context) {
        super(context);
        bounceffect();
    }

    public MyVerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bounceffect();
    }
    public void   bounceffect(){
        setPageTransformer(true,new ViewPagerTransformer());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    private MotionEvent SwipeXY(MotionEvent motionEvent){
        float x=getWidth();
        float y=getHeight();

        float NewX=(motionEvent.getY()/y)*y;
        float NewY=(motionEvent.getX()/x)*x;

        motionEvent.setLocation(NewX,NewY);

        return motionEvent;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept=super.onInterceptTouchEvent(SwipeXY(ev));

        SwipeXY(ev);

        return intercept;

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(SwipeXY(ev));

    }
    public class ViewPagerTransformer implements ViewPager.PageTransformer{

        private static final float M_SCALE=0.65f;
        @Override
        public void transformPage(@NonNull View page, float position) {
            if (position<-1){
                page.setAlpha(0);
            }else if (position<=0){
                page.setAlpha(1);
                page.setTranslationX(page.getWidth()*-position);
                page.setTranslationY(page.getHeight()*position);

                page.setScaleX(1);
                page.setScaleY(1);
            }else if (position<=1){
                page.setAlpha(1-position);
                page.setTranslationX(page.getWidth()*-position);
                page.setTranslationY(0);
                float scal_facter=M_SCALE+(1-M_SCALE)*(1-Math.abs(position));
                page.setScaleX(scal_facter);
                page.setScaleY(scal_facter);
            }else if (position>1){
                page.setAlpha(0);
            }

        }
    }
}