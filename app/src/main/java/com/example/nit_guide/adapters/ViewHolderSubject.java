package com.example.nit_guide.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;

public class ViewHolderSubject extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView subject;
    AdapterListSubject.myListener listen;
    public ViewHolderSubject(@NonNull View itemView, AdapterListSubject.myListener listen) {
        super (itemView);
        this.listen=listen;
        subject = (TextView)itemView.findViewById (R.id.tv_rec);
        itemView.setOnClickListener (this);
    }

    @Override
    public void onClick(View view) {
        listen.onNoteClick (getAdapterPosition ());
    }


}
