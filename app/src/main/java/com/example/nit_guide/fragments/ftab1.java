package com.example.nit_guide.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nit_guide.activities.contact_list;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.R;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ftab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ftab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab1 extends Fragment implements AdapterContacts.onNoteListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    View rootView;
    private String mParam1;
    private String mParam2;
    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> contactList;

    private OnFragmentInteractionListener mListener;

    public ftab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab1.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab1 newInstance(String param1, String param2) {
        ftab1 fragment = new ftab1();
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
        contactList=new ArrayList<>();
        contactList=dataqueue();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         rootView = inflater.inflate(R.layout.fragment_ftab1, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_contactDep);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new AdapterContacts(getContext(),contactList,this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<ModelContacts> dataqueue(){
        ArrayList<ModelContacts> holder=new ArrayList<>();
        ModelContacts ob1=new ModelContacts();
        ob1.setHeading("Computer Department");
        ob1.setSubHeading("Faculty members of CS Department");
        ob1.setImgName(R.drawable.dep);
        holder.add(ob1);

        ModelContacts ob2=new ModelContacts();
        ob2.setHeading("ECE Department");
        ob2.setSubHeading("Faculty members of ECE Department");
        ob2.setImgName(R.drawable.dep);
        holder.add(ob2);

        ModelContacts ob3=new ModelContacts();
        ob3.setHeading("Electrical Department");
        ob3.setSubHeading("Faculty members of EE Department");
        ob3.setImgName(R.drawable.dep);
        holder.add(ob3);

        ModelContacts ob4=new ModelContacts();
        ob4.setHeading("Mechanical Department");
        ob4.setSubHeading("Faculty members of ME Department");
        ob4.setImgName(R.drawable.dep);
        holder.add(ob4);


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

        Log.d (TAG, "onNoteClick: Clicked");
        Intent intent = new Intent(getContext(), contact_list.class);
        ArrayList<String> intentMsg = new ArrayList<>();
        intentMsg.clear();
        switch (position) {
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
        intent.putExtra("select",intentMsg);
        startActivity(intent);
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
