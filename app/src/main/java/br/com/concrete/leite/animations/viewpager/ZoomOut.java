package br.com.concrete.leite.animations.viewpager;


import android.support.v4.view.ViewPager;
import android.view.View;

public class ZoomOut implements ViewPager.PageTransformer {

    private final float MIN_SCALE = 0.85f;
    private final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1)
            page.setAlpha(0f);
        else if (position <= 1){
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
            float horizontalMargin = pageWidth * (1 - scaleFactor) / 2;

            if (position <= 0)
                page.setTranslationX(horizontalMargin - verticalMargin / 2);
            else
                page.setTranslationX(-horizontalMargin + verticalMargin / 2);

            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
        else
            page.setAlpha(0f);
    }
}
