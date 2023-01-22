package com.example.freelancerhomescreen;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.MyViewHolder>{


    @NonNull
    @Override
    public DescriptionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionAdapter.MyViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

        }


    }
}
