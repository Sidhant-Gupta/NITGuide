package com.example.nit_guide.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;

public class ViewHolderOLX extends RecyclerView.ViewHolder {
    ImageView itemImg;
    TextView title,desc,priceVal,name,phone;

    public ViewHolderOLX(@NonNull View itemView) {
        super(itemView);
        itemImg=(ImageView)itemView.findViewById(R.id.img_item);
        title=(TextView)itemView.findViewById(R.id.tv_title);
        desc=(TextView)itemView.findViewById(R.id.tv_desc);
        priceVal=(TextView)itemView.findViewById(R.id.tv_priceval);
        name=(TextView)itemView.findViewById(R.id.tv_name);
        phone=(TextView)itemView.findViewById(R.id.tv_phone);
    }
}
