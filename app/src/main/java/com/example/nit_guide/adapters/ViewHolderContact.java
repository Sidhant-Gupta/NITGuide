package com.example.nit_guide.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.activities.contact_list;

import java.util.ArrayList;

public class ViewHolderContact extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView tvHeading,tvSubHeading;
    AdapterContacts.onNoteListener onNoteListener;
    private final Context context;
    String fragment;
//    Button btn;

    public ViewHolderContact(@NonNull View itemView, AdapterContacts.onNoteListener onNoteListener) {
        super(itemView);
        context=itemView.getContext();
        img=(ImageView)itemView.findViewById(R.id.img_contact);
        tvHeading=(TextView)itemView.findViewById(R.id.tv_heading);
        tvSubHeading=(TextView)itemView.findViewById(R.id.tv_subheading);
//        btn = (Button)itemView.findViewById (R.id.gotomap);

        this.onNoteListener = onNoteListener;
        itemView.setOnClickListener (this);
    }

    @Override
    public void onClick(View view) {
        onNoteListener.onNoteClick (getAdapterPosition ());
    }



}
