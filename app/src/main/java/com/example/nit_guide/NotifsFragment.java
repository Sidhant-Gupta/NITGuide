package com.example.nit_guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotifsFragment extends Fragment  {


    public NotifsFragment(){

    }

    public static NotifsFragment newInstance(String p1,String p2){
        NotifsFragment f=new NotifsFragment ();
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifs,container,false);
    }


//    @Override
//    public void onClick(View view) {
//        getActivity().getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
}

