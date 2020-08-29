package com.example.deltahackathonui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieDetails extends AppCompatActivity {

    public static String title;
    public static String desc;
    public static String rating;

    private String[] timeSlots = {"7.00am", "11.30am", "2.00pm", "5.30pm", "7.30pm", "11.30pm"};
    private TimeSlotAdapter timeSlotAdapter;
    private RecyclerView recyclerView;

    private ViewPager viewPager;
    private TextView movieTitle;
    private TextView tvdesc;
    private TextView tvrating;
    private Button book;
    private Button pay;
    private GridView gridView;

    private RelativeLayout one;
    private RelativeLayout two;
    private RelativeLayout three;

    private int[] resids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();

        viewPager = findViewById(R.id.view_img);
        movieTitle = findViewById(R.id.view_title);
        tvdesc = findViewById(R.id.view_desc);
        tvrating = findViewById(R.id.view_rating);
        book = findViewById(R.id.btn_book);
        pay = findViewById(R.id.pay_now);
        gridView = findViewById(R.id.grid_view);
        recyclerView = findViewById(R.id.time_rview);

        one = findViewById(R.id.about_movie);
        two = findViewById(R.id.seat_selection);
        three = findViewById(R.id.date_select);
        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.GONE);
        three.setVisibility(View.GONE);

        pay.setEnabled(false);

        final GridAdapter adapter1 = new GridAdapter(this);
        gridView.setAdapter(adapter1);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(adapter1.count == 0) {
                    pay.setText("Choose your seats");
                    pay.setEnabled(false);
                }
                pay.setEnabled(true);
                pay.setText("Rs." + adapter1.count*20 + " | Pay now" );
            }
        });

        movieTitle.setText(title);
        tvdesc.setText(desc);
        tvrating.setText(rating);

        if(title.equals("Thor: Ragnarok")) {
            resids = new int[]{R.drawable.ragnarok1, R.drawable.ring1, R.drawable.ragnarok1};
        } else if(title.equals("The Ring")) {
            resids = new int[]{R.drawable.ring1, R.drawable.ragnarok1, R.drawable.ring1};
        } else {
            resids = new int[]{R.drawable.prestige1, R.drawable.prestige1, R.drawable.prestige1};
        }

        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(this, resids);

        viewPager.setClipToPadding(false);
        viewPager.setPadding(100,0,100,0);
        viewPager.setPageMargin(50);

        viewPager.setAdapter(adapter);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two.setAlpha(0f);
                two.setVisibility(View.VISIBLE);

                two.animate()
                        .alpha(1f)
                        .setDuration(1000)
                        .setListener(null);

                one.animate()
                        .alpha(0f)
                        .setDuration(1000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                one.setVisibility(View.GONE);
                            }
                        });
            }
        });

        timeSlotAdapter = new TimeSlotAdapter(timeSlots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView.setAdapter(timeSlotAdapter);

    }
}