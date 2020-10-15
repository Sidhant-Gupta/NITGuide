package com.example.nit_guide.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.adapters.AdapterTimetable;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.models.ModelTimetable;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ftab_timetable.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ftab_timetable#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab_timetable extends Fragment implements AdapterTimetable.onNoteListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    View rootView;
    private String mParam1;
    private String mParam2;
    private AdapterTimetable adapter;
    private RecyclerView recyclerView;
    private ImageView dayImg;
    private int tabno;
    ArrayList<ModelTimetable> timeTableList;

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
        timeTableList=dataqueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_ftab_timetable, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_timetable);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dayImg=(ImageView)rootView.findViewById((R.id.minion_mon));
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

        adapter=new AdapterTimetable(getContext(),timeTableList,this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<ModelTimetable> dataqueue(){
        ArrayList<ModelTimetable> holder=new ArrayList<>();
        ModelTimetable ob1=new ModelTimetable();
        ob1.setTime("830-9:25 am");;
        ob1.setSubject("DBMS");
        ob1.setRoom("LHC 201");
        ob1.setImg(R.drawable.blue_dot);

        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);
        holder.add(ob1);

//        ModelTimetable ob2=new ModelTimetable();
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//
//        ModelTimetable ob1=new ModelTimetable();
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//
//        ModelTimetable ob1=new ModelTimetable();
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//
//        ModelTimetable ob1=new ModelTimetable();
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//
//        ModelTimetable ob1=new ModelTimetable();
//        ob1.setTime("830-9:25 am");;
//        ob1.setSubject("DBMS");
//        ob1.setImg(R.drawable.dep);
//        holder.add(ob1);
//

        return holder;

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

    @Override
    public void onNoteClick(int position) {

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
