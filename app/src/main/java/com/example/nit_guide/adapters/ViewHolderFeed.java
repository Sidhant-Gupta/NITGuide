package com.example.nit_guide.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;

public class ViewHolderFeed extends RecyclerView.ViewHolder {
    ImageView img_logo,img_poster;
    TextView title,writeUp;

    public ViewHolderFeed(@NonNull View itemView) {
        super(itemView);
        img_logo=(ImageView)itemView.findViewById(R.id.img_logo);
        title=(TextView)itemView.findViewById(R.id.tv_heading_feed);
        img_poster=(ImageView)itemView.findViewById(R.id.img_poster);
        writeUp=(TextView)itemView.findViewById(R.id.tv_writeup);
    }
}
