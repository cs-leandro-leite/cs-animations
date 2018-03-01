package br.com.concrete.leite.nerdanimation.frame;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.concrete.leite.nerdanimation.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrameAnimationFragment extends Fragment {

    public static FrameAnimationFragment newInstance() {
        return new FrameAnimationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_animation, container, false);

        ImageView imageView = view.findViewById(R.id.image_view);

        imageView.setBackgroundResource(R.drawable.frame_anim);

        AnimationDrawable frameAnimation = (AnimationDrawable) imageView.getBackground();
        frameAnimation.start();

        return view;
    }

}
