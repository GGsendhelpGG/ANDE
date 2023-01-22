package com.example.freelancerhomescreen;

import android.util.Log;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExperienceRecyclerAdapter extends RecyclerView.Adapter<ExperienceRecyclerAdapter.MyViewHolder> {
    private ArrayList<ExperienceRecyclerItem> experience_list;

    public ExperienceRecyclerAdapter(ArrayList<ExperienceRecyclerItem> experience_list) {
        this.experience_list = experience_list;
    }

    @NonNull
    @Override
    public ExperienceRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvexperience_card, parent, false);

        //Create View Holder
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);
        Log.d("STATUS", "View Holder created");

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExperienceRecyclerAdapter.MyViewHolder holder, int position) {
        String name = experience_list.get(position).getName();
        String startDate = experience_list.get(position).getStartDate();
        String endDate = experience_list.get(position).getEndDate();
        String description = experience_list.get(position).getDescription();
        Log.d("Name: ", name);
        Log.d("Start Date: ", startDate);
        Log.d("End Date: ", endDate);
        Log.d("Description: ", description);


//        holder.nameTxt.setText(name);
//        holder.emailTxt.setText(email);
    }

    @Override
    public int getItemCount() {
        return experience_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView startDate;
        private TextView endDate;
        private TextView jobTitle;
        private TextView description;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            jobTitle = itemView.findViewById(R.id.jobName);
            startDate = itemView.findViewById(R.id.startDate);
            endDate = itemView.findViewById(R.id.endDate);
            //description = itemView.findViewById(R.id.description);
            //constraintLayout = itemView.findViewById(R.id.descriptionExpandedLayout);


        }


    }
}
