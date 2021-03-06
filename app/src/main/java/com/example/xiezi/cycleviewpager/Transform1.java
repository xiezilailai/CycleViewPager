package com.example.xiezi.cycleviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 蝎子莱莱123 on 2015/11/28.
 */
public class Transform1 implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;
    @Override
    public void transformPage(View page, float position) {

        int pageWidth=page.getWidth();
        if(position<-1){
            page.setAlpha(0);
        }else if(position<=0){
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        }else if(position<=1){
            page.setAlpha(1 - position);

            // Counteract the default slide transition
            page.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
        else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }

    }
}
