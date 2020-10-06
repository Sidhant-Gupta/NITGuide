package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.models.ModelContacts;

import java.util.ArrayList;

public class AdapterContacts extends RecyclerView.Adapter<ViewHolderContact> {

    ArrayList<ModelContacts>data;
    LayoutInflater inflater;

    public AdapterContacts(Context context, ArrayList<ModelContacts> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolderContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row_contact,parent,false);
        return new ViewHolderContact(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContact holder, int position) {
        holder.tvHeading.setText(data.get(position).getHeading());
        holder.tvSubHeading.setText(data.get(position).getSubHeading());
        holder.img.setImageResource(data.get(position).getImgName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
