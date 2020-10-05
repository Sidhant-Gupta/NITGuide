package com.example.nit_guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.models.modalClass;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    private List<modalClass> modalClasslist;

    public Adapter(List<modalClass> modalclasslist) {
        this.modalClasslist = modalclasslist;
    }

    static class Viewholder extends RecyclerView.ViewHolder{


        private static ImageView iv;
        private static TextView tv;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_rec);
            tv=itemView.findViewById(R.id.tv_rec);
        }
        private static void setData(int resource, String description){
            iv.setImageResource(resource);
            tv.setText(description);

        }
    }
    @NonNull
    @Override
    public Adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Viewholder holder, int position) {
        int resource=modalClasslist.get(position).getImageResource();
        String description=modalClasslist.get(position).getTv_rec();
        Viewholder.setData(resource,description);
    }

    @Override
    public int getItemCount() {
        return modalClasslist.size();
    }
}
