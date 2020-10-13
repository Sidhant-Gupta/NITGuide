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

    public ViewHolderContact(@NonNull View itemView, AdapterContacts.onNoteListener onNoteListener,String fragment) {
        super(itemView);
        context=itemView.getContext();
        this.fragment=fragment;
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
        Intent intent = new Intent(context, contact_list.class);
        ArrayList<String> intentMsg = new ArrayList<>();
        intentMsg.clear();
        if(fragment.equals("departments")) {
            switch (getAdapterPosition()) {
                case 0:
                    intentMsg.add("CSE");
                    break;
                case 1:
                    intentMsg.add("ECE");
                    break;
                case 2:
                    intentMsg.add("Electrical");
                    break;
                case 3:
                    intentMsg.add("CSE");
                    break;
                default:
                    intentMsg.add("CSE");
                    break;
            }
            intentMsg.add("Department");
        }
        else if(fragment.equals("hostels")){
            switch (getAdapterPosition()) {
                case 0:
                    intentMsg.add("Boys");
                    break;
                case 1:
                    intentMsg.add("Girls");
                    break;
                default:
                    intentMsg.add("Boys");
                    break;
            }
            intentMsg.add("Hostel");
        }
        else if(fragment.equals("khokha")){}
        else if(fragment.equals("restaurants")){}
        else if(fragment.equals("about")){}
        else if(fragment.equals("fun_spots")){}

        intent.putExtra("select",intentMsg);
        context.startActivity(intent);
    }



}
