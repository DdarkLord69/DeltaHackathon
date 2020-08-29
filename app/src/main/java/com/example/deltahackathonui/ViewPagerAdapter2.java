package com.example.deltahackathonui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter2 extends PagerAdapter {
    private Context context;
    private int[] resids;

    public ViewPagerAdapter2(Context context, int[] resids) {
        this.context = context;
        this.resids = resids;
    }

    @Override
    public int getCount() {
        return resids.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);

        imageView.setImageResource(resids[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setMaxHeight(300);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
