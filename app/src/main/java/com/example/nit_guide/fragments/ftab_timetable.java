package com.example.nit_guide.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.adapters.TimeTableOpen;
import com.example.nit_guide.db_contact;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.models.ModelTimetable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ftab_timetable.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ftab_timetable#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab_timetable extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    View rootView;
    private String mParam1;
    private String mParam2;
    private TimeTableOpen adapter;
    private RecyclerView recyclerView;
    private ImageView dayImg;
    private int tabno;
    private ArrayList<ModelTimetable> holder=new ArrayList<>();
    ArrayList<ModelTimetable> timeTableList;
    ArrayList<String> intentMsg;
     String branch,section,year;

    Context mcontext=null ;

    interface DataReceivedListener{
        void onDataReceived(ArrayList<ModelTimetable> timetable,List<String>keys);
    }

    private OnFragmentInteractionListener mListener;

    public ftab_timetable(int tabno) {
        // Required empty public constructor
        this.tabno=tabno;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab_timetable.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab_timetable newInstance(String param1, String param2) {
        ftab_timetable fragment = new ftab_timetable(0);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        timeTableList=new ArrayList<>();
        intentMsg =getActivity().getIntent ( ).getStringArrayListExtra ("Branch, Year, Day and Section");
        branch = intentMsg.get (0);
        year = intentMsg.get (1);
        section = intentMsg.get (3);
        dataqueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_ftab_timetable, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_timetable);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dayImg=(ImageView)rootView.findViewById((R.id.minion_mon));

        intentMsg =getActivity().getIntent ( ).getStringArrayListExtra ("Branch, Year, Day and Section");

        if(tabno==0)
            dayImg.setImageResource(R.drawable.tt_monday);
        else if(tabno==1)
            dayImg.setImageResource(R.drawable.tt_tuesday);
        else if(tabno==2)
            dayImg.setImageResource(R.drawable.tt_wed);
        else if(tabno==3)
            dayImg.setImageResource(R.drawable.tt_thursday);
        else if(tabno==4)
            dayImg.setImageResource(R.drawable.tt_friday);

        mcontext=getContext();
        List<String>keys=new ArrayList<>();
        timeTableList=new ArrayList<>();
        dataqueue();
        new TimeTableOpen().setConfig(recyclerView,getContext(),timeTableList,keys);

        return rootView;
    }
    public void dataqueue(){
        final DataSnapshot snapshot=null;
        String day;
        switch(tabno){
            case 0:
                day="Monday";
                break;
            case 1:
                day="Tuesday";
                break;
            case 2:
                day="Wednesday";
                break;
            case 3:
                day="Thursday";
                break;
            case 4:
                day="Friday";
                break;
            default:
                day="Monday";
                break;
        }
        System.out.println("Taaaaaabbbb noooo "+tabno);
        System.out.println("DAYYYYYYYYY "+day);
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Department").child(intentMsg.get(0).toString()).child("TimeTable").child(intentMsg.get(1).toString()).child(intentMsg.get(3).toString()).child(day);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                holder.clear();
                List<String> keys=new ArrayList<>();
                for(DataSnapshot keynode:dataSnapshot.getChildren()){
                    keys.add(keynode.getKey());
                    ModelTimetable ob1=keynode.getValue(ModelTimetable.class);
                    holder.add(ob1);
                }
                onDataRecieved(holder,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void onDataRecieved(ArrayList<ModelTimetable> timetable,List<String>keys){
        new TimeTableOpen().setConfig(recyclerView,mcontext,timetable,keys);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
