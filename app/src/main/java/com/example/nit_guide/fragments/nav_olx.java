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
import android.widget.Button;

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.adapters.AdapterOLX;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.models.ModelOLX;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link nav_olx.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link nav_olx#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_olx extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View rootView;
    private AdapterOLX adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelOLX> olxitemList;

    private OnFragmentInteractionListener mListener;

    public nav_olx() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_olx.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_olx newInstance(String param1, String param2) {
        nav_olx fragment = new nav_olx();
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
        olxitemList=new ArrayList<>();
        olxitemList=dataqueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_olx, container, false);
        // 1. get a reference to recyclerView
        Button sell=(Button)rootView.findViewById(R.id.btn_sell);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_olx);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new AdapterOLX(getContext(),olxitemList);
        recyclerView.setAdapter(adapter);

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSf9EPNiTUSyAzoKvaZXQ_1s0o33Yc7scG4Qije9X1eESAKlhA/viewform?usp=sf_link"));
                startActivity(myWebLink);
            }
        });

        return rootView;
    }

    public ArrayList<ModelOLX> dataqueue(){
        ArrayList<ModelOLX> holder=new ArrayList<>();
        ModelOLX ob1=new ModelOLX();
        ob1.setTitle("Cycle");
        ob1.setDesc("Faculty members of CS Department");
        ob1.setPriceVal("3500");
        ob1.setName("John");
        ob1.setPhone("7825333908");
        ob1.setItemImg(R.drawable.boyshostel);
        holder.add(ob1);

        ModelOLX ob2=new ModelOLX();
        ob2.setTitle("Cooler");
        ob2.setDesc("Faculty members of CS Department");
        ob2.setPriceVal("3500");
        ob2.setName("Aladin");
        ob2.setPhone("7825333908");
        ob2.setItemImg(R.drawable.boyshostel);
        holder.add(ob2);

        ModelOLX ob3=new ModelOLX();
        ob3.setTitle("Induction");
        ob3.setDesc("Faculty members of CS Department");
        ob3.setPriceVal("3500");
        ob3.setName("Jasmine");
        ob3.setPhone("7825333908");
        ob3.setItemImg(R.drawable.boyshostel);
        holder.add(ob3);
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
