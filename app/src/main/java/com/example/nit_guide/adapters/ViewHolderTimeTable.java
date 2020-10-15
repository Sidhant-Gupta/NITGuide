package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;

public class ViewHolderTimeTable extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView img;
    TextView tvTime,tvSubject,tvRoom;
//    AdapterContacts.onNoteListener onNoteListener;
    private final Context context;
    AdapterTimetable.onNoteListener onNoteListener;

    public ViewHolderTimeTable(@NonNull View itemView, AdapterTimetable.onNoteListener onNoteListener) {
        super(itemView);
        this.context = itemView.getContext();
        img=(ImageView)itemView.findViewById(R.id.img_dot);
        tvTime=(TextView)itemView.findViewById(R.id.tv_time);
        tvSubject=(TextView)itemView.findViewById(R.id.tv_subject);
        tvRoom=(TextView)itemView.findViewById(R.id.tv_room);

        this.onNoteListener = onNoteListener;
        itemView.setOnClickListener (this);
    }

    @Override
    public void onClick(View view) {

    }
}
