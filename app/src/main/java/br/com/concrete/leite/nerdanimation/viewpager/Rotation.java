package br.com.concrete.leite.nerdanimation.viewpager;


import android.support.v4.view.ViewPager;
import android.view.View;

public class Rotation implements ViewPager.PageTransformer {

    private final int DEGREES = 150;
    private final float MIN_ALPHA = 0.7f;
    private float centerFactor = (float) Math.tan(Math.toRadians(DEGREES / 2)) / 2;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        page.setPivotX((float) pageWidth/2);
        page.setPivotY(pageHeight + pageWidth * centerFactor);

        if (position >= - 1 || position <= 1){
            page.setTranslationX((-position) * pageWidth);
            page.setRotation(position * (180 - DEGREES));
            page.setAlpha(Math.max(MIN_ALPHA, 1 - Math.abs(position)/3));
        }
        else {
            page.setRotation(0f);
            page.setAlpha(0f);
        }
    }
}
