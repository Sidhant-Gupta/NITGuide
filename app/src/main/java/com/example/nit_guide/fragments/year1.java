package com.example.nit_guide.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nit_guide.R;
import com.example.nit_guide.activities.openPapers_db;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.adapters.AdapterListSubject;
import com.example.nit_guide.models.modelClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link year1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link year1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class year1 extends Fragment implements AdapterListSubject.myListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String subject;
    View rootView;
    private AdapterListSubject adapter;
    private RecyclerView rv;
    ArrayList<modelClass> subjectsList;

    private AdapterListSubject.myListener myListener;

    private OnFragmentInteractionListener mListener;

    public year1() {
        // Required empty public constructor
    }
    public year1(String s){
        subject = s;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment year1.
     */
    // TODO: Rename and change types and number of parameters
    public static year1 newInstance(String param1, String param2) {
        year1 fragment = new year1 ( );
        Bundle args = new Bundle ( );
        args.putString (ARG_PARAM1, param1);
        args.putString (ARG_PARAM2, param2);
        fragment.setArguments (args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (getArguments ( ) != null) {
            mParam1 = getArguments ( ).getString (ARG_PARAM1);
            mParam2 = getArguments ( ).getString (ARG_PARAM2);
        }
        subjectsList=new ArrayList<>();
        subjectsList=dataqueue(subject);
    }

    private ArrayList<modelClass> dataqueue(String subject) {

        ArrayList<modelClass> holder=new ArrayList<>();

        if(subject.equalsIgnoreCase ("COmputer")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);

        }
        else if(subject.equalsIgnoreCase ("IT")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);

            modelClass ob3=new modelClass ();
            ob2.setTv_rec ("Database Management");
            holder.add (ob2);
        }
        else if(subject.equalsIgnoreCase ("ECE")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);
        }
        else if(subject.equalsIgnoreCase ("Electrical")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);
        }
        else if(subject.equalsIgnoreCase ("Mechanical")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);
        }
        else if(subject.equalsIgnoreCase ("Civil")){
            //physis sem-1
            modelClass ob1=new modelClass ();
            ob1.setTv_rec ("Physics I (PHY111T)");
            holder.add(ob1);

            //physics sem2
            modelClass ob2 = new modelClass ();
            ob2.setTv_rec ("Physics II (PHY112T)");
            holder.add(ob2);
        }


        return holder;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate (R.layout.fragment_year1, container, false);
        // 1. get a reference to recyclerView
        rv = (RecyclerView) rootView.findViewById(R.id.rv_subjects);
        rv.setLayoutManager(new LinearLayoutManager (getContext()));
        adapter=new AdapterListSubject (getContext(),subjectsList,myListener);
        rv.setAdapter(adapter);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction (uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException (context.toString ( )
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach ( );
        mListener = null;
    }

    @Override
    public void onNoteClick(int position) {
        Intent t =  new Intent(getContext (), openPapers_db.class);
//        t.putExtra("obj", restList.get (position).getHeading ());

        ArrayList<String> list = null;
        list.add("1");
        list.add(subjectsList.get (position).getTv_rec ());
        t.putStringArrayListExtra ("Year+Subject", list);
        startActivity (t);
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
