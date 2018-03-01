package br.com.concrete.leite.nerdanimation.viewpager;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.concrete.leite.nerdanimation.R;

class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private int[] imageIds;

    public ViewPagerAdapter(Context context, int[] imageIds) {
        this.context = context;
        this.imageIds = imageIds;
    }

    @Override
    public int getCount() {
        return imageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_view_pager, container, false);

        imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(imageIds[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
