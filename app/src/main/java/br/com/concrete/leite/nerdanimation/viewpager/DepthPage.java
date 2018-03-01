package br.com.concrete.leite.nerdanimation.viewpager;


import android.support.v4.view.ViewPager;
import android.view.View;

public class DepthPage implements ViewPager.PageTransformer {

    private final float MIN_SCALE = 0.80f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();

        if (position < -1)
            page.setAlpha(0f);
        else if (position <= 0){
            page.setAlpha(1f);
            page.setTranslationX(0f);
            page.setScaleX(1f);
            page.setScaleY(1f);
        }
        else if(position <= 1){
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));

            page.setAlpha(1 - position);
            page.setTranslationX(pageWidth * -position);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }
        else
            page.setAlpha(0f);
    }
}
