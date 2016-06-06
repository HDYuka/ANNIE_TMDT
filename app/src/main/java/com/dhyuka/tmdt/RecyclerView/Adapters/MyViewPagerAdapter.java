package com.dhyuka.tmdt.RecyclerView.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dhyuka.tmdt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Nguyen on 05/06/2016.
 */
public class MyViewPagerAdapter extends PagerAdapter {

    List<String> array_items;
    Context context;

    public MyViewPagerAdapter(Context context, List<String> array_items) {
        this.context = context;
        this.array_items = array_items;
    }

    @Override
    public int getCount() {
        return array_items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_image, container, false);

        ImageView imageViewPreview = (ImageView) view.findViewById(R.id.img_thumb);

        Glide.with(view.getContext()).load(array_items.get(position)).into(imageViewPreview);

        container.addView(view);

        return view;
    }


//    public void addAll(List<String> items) {
//        array_items = new ArrayList<>(items);
//
//    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
