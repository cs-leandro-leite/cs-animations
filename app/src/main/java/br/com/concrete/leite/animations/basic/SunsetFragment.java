package br.com.concrete.leite.animations.basic;


import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concrete.leite.animations.R;

public class SunsetFragment extends Fragment {

    private View sceneView;
    private View sunView;
    private View moonView;
    private View skyView;

    private int blueSkyColor;
    private int sunsetSkyColor;
    private int nightSkyColor;

    private boolean firstClick = true;

    public static SunsetFragment newInstance() {
        return new SunsetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunset, container, false);

        sceneView = view;
        sunView = view.findViewById(R.id.sun);
        moonView = view.findViewById(R.id.moon);
        skyView = view.findViewById(R.id.sky);

        Resources resources = getResources();
        blueSkyColor = resources.getColor(R.color.blue_sky);
        sunsetSkyColor = resources.getColor(R.color.sunset_sky);
        nightSkyColor = resources.getColor(R.color.night_sky);

        sceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstClick)
                    startAnimation();
                else
                    finishAnimation();

                firstClick = !firstClick;
            }
        });

        return view;
    }

    private void startAnimation() {
        float sunYStart = sunView.getTop();
        float sunYEnd = skyView.getHeight();

        ObjectAnimator sunAnimator = ObjectAnimator
                .ofFloat(sunView, "y", sunYStart, sunYEnd)
                .setDuration(3000);

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", blueSkyColor, sunsetSkyColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", sunsetSkyColor, nightSkyColor)
                .setDuration(1500);
        nightSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator moonAnimator = ObjectAnimator
                .ofFloat(moonView, "alpha", 0f, 1f)
                .setDuration(2000);
        moonAnimator.setStartDelay(1500);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(sunAnimator)
                .with(sunsetSkyAnimator)
                .before(nightSkyAnimator)
                .before(moonAnimator);
        animatorSet.start();
    }

    private void finishAnimation() {
        ObjectAnimator sunAnimator = ObjectAnimator
                .ofFloat(sunView, "y", skyView.getHeight(), sunView.getTop())
                .setDuration(3000);

        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
                .ofInt(skyView, "backgroundColor", sunsetSkyColor, blueSkyColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());

        ObjectAnimator nightSkyAnimator = ObjectAnimator
                .ofObject(skyView, "backgroundColor", new ArgbEvaluator(), nightSkyColor, sunsetSkyColor)
                .setDuration(1500);

        ObjectAnimator moonAnimator = ObjectAnimator
                .ofFloat(moonView, "alpha", 1f, 0f)
                .setDuration(3000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .play(moonAnimator)
                .with(nightSkyAnimator)
                .before(sunsetSkyAnimator)
                .before(sunAnimator);
        animatorSet.start();
    }
}
