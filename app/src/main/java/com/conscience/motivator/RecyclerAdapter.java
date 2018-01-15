package com.conscience.motivator;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] titles = {"one", "two", "three", "four", "five", "six", "seven"};

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView goalTitle;
        public ViewHolder(View itemView){
            super(itemView);
            goalTitle = (TextView)itemView.findViewById(R.id.goalTitle);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_view, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.goalTitle.setText(titles[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
