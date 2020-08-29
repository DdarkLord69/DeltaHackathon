package com.example.deltahackathonui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private Activity activity;
    private List<ViewItemModel> viewItemModels;
    private OnItemClickListener listener;

    public ViewPagerAdapter(Context context, Activity activity, List<ViewItemModel> viewItemModels) {
        this.context = context;
        this.activity = activity;
        this.viewItemModels = viewItemModels;
    }

    @Override
    public int getCount() {
        return viewItemModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_item, container, false);
        final ViewItemModel currentItem = viewItemModels.get(position);

        final TextView title = v.findViewById(R.id.view_title);
        final TextView desc = v.findViewById(R.id.view_desc);
        final TextView rating = v.findViewById(R.id.view_rating);
        final ImageView img = v.findViewById(R.id.view_img);

        title.setText(currentItem.getName());
        rating.setText(currentItem.getRating());
        desc.setText(currentItem.getDesc());
        img.setImageResource(currentItem.getResid());

        container.addView(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position, title, desc, rating, img);
            }
        });

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View... views);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
