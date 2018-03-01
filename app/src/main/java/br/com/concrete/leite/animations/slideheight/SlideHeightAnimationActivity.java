package br.com.concrete.leite.animations.slideheight;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import br.com.concrete.leite.animations.R;


public class SlideHeightAnimationActivity extends AppCompatActivity {

    final static int MIN_HEIGHT = 0;
    final static int MAX_HEIGHT = 216;

    RelativeLayout header;
    LinearLayout body;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_height_animation);

        setupViews();
        setupAnimatorSet();
        startAnimationDelayed();
    }

    private void setupViews() {
        header = findViewById(R.id.contact_header);
        body = findViewById(R.id.contact_body);
    }

    private void setupAnimatorSet() {
        ValueAnimator slideAnimator = setupSlideAnimation();
        animatorSet = new AnimatorSet();
        animatorSet.play(slideAnimator);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    private ValueAnimator setupSlideAnimation(){
        ValueAnimator slideAnimator = ValueAnimator
                .ofInt(MIN_HEIGHT, MAX_HEIGHT)
                .setDuration(1000);

        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer updatedHeightValue = (Integer) animation.getAnimatedValue();
                body.getLayoutParams().height = updatedHeightValue;
                body.requestLayout();
            }
        });

        return slideAnimator;
    }

    private void startAnimationDelayed() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animatorSet.start();
            }
        }, 1000);
    }
}
