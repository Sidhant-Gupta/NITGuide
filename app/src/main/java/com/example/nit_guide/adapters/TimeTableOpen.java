package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.models.ModelTimetable;

import java.util.ArrayList;
import java.util.List;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.nit_guide.Adapter;
        import com.example.nit_guide.R;
        import com.example.nit_guide.models.FBModelContacts;
        import com.example.nit_guide.models.ModelTimetable;

        import java.util.ArrayList;
        import java.util.List;

public class TimeTableOpen {
    private Context context;

    private AdapterTimeTable adapterTimeTable;
    public void setConfig(RecyclerView recyclerView, Context mcontext, ArrayList<ModelTimetable> periods, List<String> keys){
        System.out.println("Adapterrr setttttttt");
        context=mcontext;
        adapterTimeTable=new AdapterTimeTable(periods,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapterTimeTable);
    }

    class ViewHolderTimetable extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTime,tvSubject,tvRoom;


        private String key;

        public ViewHolderTimetable(ViewGroup parent) {
            super(LayoutInflater.from(context).inflate(R.layout.single_row_timetable,parent,false));
            context = itemView.getContext();
            img=(ImageView)itemView.findViewById(R.id.img_dot);
            tvTime=(TextView)itemView.findViewById(R.id.tv_time);
            tvSubject=(TextView)itemView.findViewById(R.id.tv_subject);
            tvRoom=(TextView)itemView.findViewById(R.id.tv_room);
        }

        public void Bind(ModelTimetable obj,String key) {
            tvTime.setText(obj.getTime());
            tvRoom.setText(obj.getRoom());
            tvSubject.setText(obj.getSubject());
            img.setImageResource(R.drawable.blue_dot);
            this.key = key;

        }
    }
    class AdapterTimeTable extends RecyclerView.Adapter<ViewHolderTimetable>{
        private ArrayList<ModelTimetable> periodList;
        private List<String>mkeys;

        public AdapterTimeTable(ArrayList<ModelTimetable> periodList, List<String> mkeys) {
            this.periodList = periodList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public ViewHolderTimetable onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolderTimetable(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderTimetable holder, int position) {
            holder.Bind(periodList.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return periodList.size();
        }
    }
}
