package com.example.deltahackathonui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotHolder> {
    private String[] timeSlots;
    private int[] h = {100, 40, 60, 70, 10, 90, 30, 50, 10, 70};

    public TimeSlotAdapter(String[] timeSlots) {
        this.timeSlots = timeSlots;
    }

    @NonNull
    @Override
    public TimeSlotHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeslot_item, parent, false);

        return new TimeSlotHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotHolder holder, int position) {
        holder.time.setText(timeSlots[position]);
        holder.bar.setLayoutParams(new ViewGroup.LayoutParams(50, h[position]));
    }

    @Override
    public int getItemCount() {
        return timeSlots.length;
    }

    public class TimeSlotHolder extends RecyclerView.ViewHolder {

        View bar;
        TextView time;

        public TimeSlotHolder(@NonNull View itemView) {
            super(itemView);

            bar = itemView.findViewById(R.id.time_bar);
            time = itemView.findViewById(R.id.timeslot);
        }
    }
}
