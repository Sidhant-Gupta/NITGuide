package com.example.nit_guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment  {


//    private OnFragmentInteractionListener fraglistener;

    public HomeFragment(){

    }

    public static HomeFragment newInstance(String p1,String p2){
        HomeFragment f=new HomeFragment ();
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

//    public void onButtonPressed(Uri uri){
//        if(fraglistener!=null) {
//            fraglistener.onFragmentInteraction(uri);
//        }
//
//    }

//    @Override
//    public void onClick(View view) {
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
}

