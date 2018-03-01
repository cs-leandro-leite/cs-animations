package br.com.concrete.leite.nerdanimation.crossfade;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import br.com.concrete.leite.nerdanimation.R;

public class CrossfadeViewActivity extends AppCompatActivity {

    ImageView ivCover;
    ProgressBar progressBar;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade_view);

        setupViews();
        setupAnimatorSet();
        startAnimation();
    }

    private void setupViews() {
        ivCover = findViewById(R.id.iv_cover);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void setupAnimatorSet() {
        final ObjectAnimator imageFadeInAnimation = setupFadeInAnimation();

        animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.crossfade_progress);
        animatorSet.setTarget(progressBar);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageFadeInAnimation.start();
            }
        });
    }

    private ObjectAnimator setupFadeInAnimation(){
        ObjectAnimator imageFadeInAnimation = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.crossfade_img_show);
        imageFadeInAnimation.setTarget(ivCover);

        return imageFadeInAnimation;
    }

    private void startAnimation() {
        animatorSet.start();
    }
}
