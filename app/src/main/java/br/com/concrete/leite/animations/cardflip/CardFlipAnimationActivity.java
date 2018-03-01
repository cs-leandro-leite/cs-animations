package br.com.concrete.leite.animations.cardflip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import br.com.concrete.leite.animations.R;

public class CardFlipAnimationActivity extends AppCompatActivity {

    FrameLayout cardContainer;
    boolean isCardShowingFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        setupViews();
        startCardWithBackSide();
    }

    private void setupViews() {
        cardContainer = findViewById(R.id.container);
        cardContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
    }

    private void startCardWithBackSide() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new CardBackFragment())
                .commit();
    }

    private void flipCard() {
        if (isCardShowingFront) {
            getSupportFragmentManager().popBackStack();
            isCardShowingFront = false;
            return;
        }

        isCardShowingFront = true;
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)

                .replace(R.id.container, new CardFrontFragment())
                .addToBackStack(null)
                .commit();
    }
}
