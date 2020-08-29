package com.example.deltahackathonui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;

public class GridAdapter extends BaseAdapter {
    private Context context;
    public int count = 0;
    private Boolean[] filled = new Boolean[36];

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 36;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);
            gridView = inflater.inflate(R.layout.seat_view, null);

        } else {
            gridView = (View) convertView;
        }

        final ImageView imageView = gridView.findViewById(R.id.img_seat);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filled[position] == null || !filled[position]) {
                    imageView.setImageResource(R.drawable.ic_filled_seat);
                    filled[position] = true;
                    count++;
                } else {
                    imageView.setImageResource(R.drawable.ic_empty_seat);
                    filled[position] = false;
                    count--;
                }
            }
        });

        return gridView;
    }
}
