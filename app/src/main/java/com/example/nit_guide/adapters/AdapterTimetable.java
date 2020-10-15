package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.models.ModelTimetable;

import java.util.ArrayList;

public class AdapterTimetable extends RecyclerView.Adapter<ViewHolderTimeTable> {
    ArrayList<ModelTimetable> data;
    LayoutInflater inflater;

    private AdapterTimetable.onNoteListener monNoteListener;
    public AdapterTimetable(Context context, ArrayList<ModelTimetable> data, AdapterTimetable.onNoteListener onNoteListener) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.monNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public ViewHolderTimeTable onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row_timetable,parent,false);
        return new ViewHolderTimeTable(view,monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTimeTable holder, final int position) {
        holder.tvSubject.setText(data.get(position).getSubject());
        holder.tvTime.setText(data.get(position).getTime());
        holder.tvRoom.setText(data.get(position).getRoom());
        holder.img.setImageResource(data.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface onNoteListener{
        void onNoteClick(int position);
    }
}
