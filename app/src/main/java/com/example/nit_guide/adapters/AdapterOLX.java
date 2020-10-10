package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.models.ModelOLX;

import java.util.ArrayList;

public class AdapterOLX extends RecyclerView.Adapter<ViewHolderOLX> {
    ArrayList<ModelOLX> data;
    LayoutInflater inflater;

    public AdapterOLX(Context context, ArrayList<ModelOLX> data) {
        this.data = data;
        this.inflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderOLX onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row_olx,parent,false);
        return new ViewHolderOLX(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOLX holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.desc.setText(data.get(position).getDesc());
        holder.priceVal.setText(data.get(position).getPriceVal());
        holder.name.setText(data.get(position).getName());
        holder.phone.setText(data.get(position).getPhone());
        holder.itemImg.setImageResource(data.get(position).getItemImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
