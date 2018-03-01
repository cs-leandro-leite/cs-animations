package br.com.concrete.leite.nerdanimation.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.concrete.leite.nerdanimation.R;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] imageIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.view_pager);
        imageIds = new int[]{R.drawable.vp_image_1, R.drawable.vp_image_2,
                R.drawable.vp_image_3, R.drawable.vp_image_4, R.drawable.vp_image_5};
        PagerAdapter adapter = new ViewPagerAdapter(this, imageIds);
        viewPager.setAdapter(adapter);
//        viewPager.setPageTransformer(true, new ZoomOut());
//        viewPager.setPageTransformer(true, new DepthPage());
        viewPager.setPageTransformer(true, new Rotation());
    }
}
