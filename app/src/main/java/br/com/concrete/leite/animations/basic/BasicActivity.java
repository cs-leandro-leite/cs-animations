package br.com.concrete.leite.animations.basic;


import android.support.v4.app.Fragment;

public class BasicActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return SunsetFragment.newInstance();
    }
}