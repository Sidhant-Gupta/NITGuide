package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.models.ModelFeed;

import java.util.ArrayList;

public class AdapterFeed extends RecyclerView.Adapter<ViewHolderFeed> {
    ArrayList<ModelFeed>data;
    LayoutInflater inflater;

    public AdapterFeed(Context context,ArrayList<ModelFeed> data) {
        this.data = data;
        this.inflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row_feed,parent,false);
        return new ViewHolderFeed(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFeed holder, int position) {
        holder.img_logo.setImageResource(data.get(position).getImg_logo());
        holder.title.setText(data.get(position).getTitle());
        holder.img_poster.setImageResource(data.get(position).getImg_poster());
        holder.writeUp.setText(data.get(position).getWriteUp());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
