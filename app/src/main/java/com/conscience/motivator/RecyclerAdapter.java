package com.conscience.motivator;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conscience.motivator.data.DBTables.AppDatabase;
import com.conscience.motivator.data.DBTables.Goal;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //private String[] goals = {"one", "two", "three", "four", "five", "six", "seven"};
    /*private String[] description = {"11","22","33","44","55"};
    private String[] dates = {"21.01","05.02","09.03","30.04","11.05"};
    private String[] times = {"13:10","11:00","06:30","17:40","21:00"};*/

    private List<Goal> goals;

    public RecyclerAdapter(List<Goal> goals) {
        this.goals = goals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView goalTitle;
        public TextView goalDetails;
        public TextView goalDate;
        public TextView goalTime;
        public ViewHolder(View itemView){
            super(itemView);
            goalTitle = itemView.findViewById(R.id.goalTitle);
            goalDetails = itemView.findViewById(R.id.goalDetail);
            goalDate = itemView.findViewById(R.id.goalDate);
            goalTime = itemView.findViewById(R.id.goalTime);

            itemView.setOnClickListener((v) -> {
                int pos = getAdapterPosition() + 1;
                Snackbar.make(v, "click on item " + pos, Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.goalTitle.setText(goals.get(position).goalTitle);
        holder.goalDetails.setText(goals.get(position).description);
        holder.goalDate.setText(goals.get(position).goalDate);
        holder.goalTime.setText(goals.get(position).goalTime);
    }

    @Override
    public int getItemCount() {
        return goals.size();
        //return description.length;
    }
}
