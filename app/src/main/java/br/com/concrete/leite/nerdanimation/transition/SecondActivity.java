package br.com.concrete.leite.nerdanimation.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.concrete.leite.nerdanimation.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);

    }
}
