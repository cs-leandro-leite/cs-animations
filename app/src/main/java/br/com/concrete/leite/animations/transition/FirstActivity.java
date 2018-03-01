package br.com.concrete.leite.animations.transition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.concrete.leite.animations.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void slideTransition(View view){
        startActivity(new Intent(this, SecondActivity.class));
        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
    }

    public void pushTransition(View view){
        startActivity(new Intent(this, SecondActivity.class));
        overridePendingTransition(R.anim.activity_push_up_in, R.anim.activity_push_up_out);
    }
}
