package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.models.modelClass;

import java.util.ArrayList;

public class AdapterListSubject extends RecyclerView.Adapter<ViewHolderSubject>{

    private myListener monNoteListener;
    ArrayList<modelClass> data;
    LayoutInflater inflater;

//    private onNoteListener monNoteListener;
    public AdapterListSubject(Context context, ArrayList<modelClass> data, myListener myListener) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;

        this.monNoteListener = myListener;
    }


    @NonNull
    @Override
    public ViewHolderSubject onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(parent.getContext ());
        View v = inflater.inflate (R.layout.item_layout, parent, false);
        return new ViewHolderSubject (v,monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSubject holder, int position) {

        holder.subject.setText (data.get(position).getTv_rec ());
    }

    @Override
    public int getItemCount() {
        return data.size ();
    }

    public interface myListener{
        void onNoteClick(int position);
    }
}
