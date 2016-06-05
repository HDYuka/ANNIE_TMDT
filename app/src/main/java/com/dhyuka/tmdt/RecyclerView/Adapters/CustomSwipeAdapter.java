package com.dhyuka.tmdt.RecyclerView.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dhyuka.tmdt.R;

import java.util.List;

/**
 * Created by Nam Nguyen on 04/06/2016.
 */
public class CustomSwipeAdapter extends PagerAdapter {

    Context context;
    List<String> resourceImage;

    public CustomSwipeAdapter(Context context, List<String> resourceImage) {
        this.context = context;
        this.resourceImage = resourceImage;

    }

    @Override
    public int getCount() {
        return resourceImage.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) v.findViewById(R.id.image_view);
//        int id = v.getResources().getIdentifier(resourceImage.get(position), "drawable","com.dhyuka.tmdt.RecyclerView.Adapters" );
//        imageView.setImageResource(id);
//        Glide.with(context).load(image.getLarge())
//                .thumbnail(0.5f)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imageView);
//        Intent intent = context.getIntent();
//        Bundle bundle = intent.getBundleExtra("bundle");
//        String value= container.getIntent().getStringExtra("username");
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }


}
