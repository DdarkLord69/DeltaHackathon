package com.example.deltahackathonui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager viewPager;

    private ViewPagerAdapter adapter;
    private List<ViewItemModel> viewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        viewItems = new ArrayList<>();

        viewItems.add(new ViewItemModel("The Ring", R.drawable.ring1, getString(R.string.ring), "Horror", "IMDB 7.1"));
        viewItems.add(new ViewItemModel("Thor: Ragnarok", R.drawable.ragnarok1, getString(R.string.ragnarok), "Action", "IMDB 7.9"));
        viewItems.add(new ViewItemModel("The Prestige", R.drawable.prestige1, getString(R.string.prestige), "Mystery", "IMDB 8.5"));

        adapter = new ViewPagerAdapter(this, this, viewItems);
        viewPager.setPageTransformer(true, new ViewPagerStack());
        viewPager.setOffscreenPageLimit(4);
        adapter.setOnItemClickListener(new ViewPagerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View... views) {
                ViewItemModel currentItem = viewItems.get(position);

                Pair<View, String> p1 = new Pair<>((View) views[0], views[0].getTransitionName());
                Pair<View, String> p2 = new Pair<>((View) views[1], views[1].getTransitionName());
                Pair<View, String> p3 = new Pair<>((View) views[2], views[2].getTransitionName());
                Pair<View, String> p4 = new Pair<>((View) views[3], views[3].getTransitionName());

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1, p2, p3, p4);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, p1, p2, p3, p4);
                startActivity(intent, options.toBundle());
                intent.putExtra("title", currentItem.getName());
                MovieDetails.title = currentItem.getName();
                MovieDetails.desc = currentItem.getDesc();
                MovieDetails.rating = currentItem.getRating();
            }
        });
        viewPager.setAdapter(adapter);

    }

    private static class ViewPagerStack implements ViewPager.PageTransformer {

        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position >= 0) {
                page.setScaleX(0.85f - 0.05f * position);
                page.setScaleY(0.85f);

                page.setTranslationX(-page.getWidth() * position);
                page.setTranslationY(20 * position);
            }
        }
    }
}