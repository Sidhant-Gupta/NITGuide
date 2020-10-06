package com.example.nit_guide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nit_guide.R;
import com.example.nit_guide.db_contact;

import java.util.List;

public class Recyclerview_contact {
    private Context mcontext;

    private ContactAdapter mContactAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<db_contact>contacts, List<String>keys){
        mcontext=context;
        mContactAdapter=new ContactAdapter(contacts,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mContactAdapter);
    }

    class ContactItemView extends RecyclerView.ViewHolder {
        private TextView tv_name,tv_desig,tv_phone,tv_email;

        private String key;

        public ContactItemView(ViewGroup parent) {
            super(LayoutInflater.from(mcontext).inflate(R.layout.contact_list_item,parent,false));
            tv_name=(TextView) itemView.findViewById(R.id.tv_cname);
            tv_desig=(TextView) itemView.findViewById(R.id.tv_designation);
            tv_phone=(TextView) itemView.findViewById(R.id.tv_phone);
            tv_email=(TextView) itemView.findViewById(R.id.tv_email);

        }
        public void Bind(db_contact con,String key) {
            tv_name.setText(con.getName());
            tv_email.setText(con.getEmail());
            tv_desig.setText(con.getDesignation());
            tv_phone.setText(con.getCont());
            this.key = key;

        }
    }
    class ContactAdapter extends RecyclerView.Adapter<ContactItemView>{
        private List<db_contact> mcontactlist;
        private List<String>mkeys;

        public ContactAdapter(List<db_contact> mcontactlist, List<String> mkeys) {
            this.mcontactlist = mcontactlist;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public ContactItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ContactItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactItemView holder, int position) {
            holder.Bind(mcontactlist.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mcontactlist.size();
        }
    }
}
