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

import com.example.nit_guide.R;
import com.example.nit_guide.adapters.AdapterContacts;
import com.example.nit_guide.adapters.AdapterFeed;
import com.example.nit_guide.models.ModelContacts;
import com.example.nit_guide.models.ModelFeed;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link nav_feed.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link nav_feed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_feed extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View rootView;
    private AdapterFeed adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelFeed> feedList;

    private ftab1.OnFragmentInteractionListener mListener;

    public nav_feed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_feed.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_feed newInstance(String param1, String param2) {
        nav_feed fragment = new nav_feed();
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
        feedList=new ArrayList<>();
        feedList=dataqueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_nav_feed, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_feed);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new AdapterFeed(getContext(),feedList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<ModelFeed> dataqueue(){
        ArrayList<ModelFeed> holder=new ArrayList<>();
        ModelFeed ob1=new ModelFeed();
        ob1.setTitle("Mental Health Day");
        ob1.setWriteUp("\"Sigh. At least there’s this one day when everyone acknowledges what I am going through. Do they? Maybe not. Maybe everyone just pretends to be ‘aware’, ‘empathetic’ and whatnot. I don’t really understand what’s wrong with talking about what I am going through. Am I the only one? Is it wrong to feel all of these emotions that I am continuously battling day in and day out?”\n" +
                "\n" +
                "To all those who ponder over such questions and are fighting some unheard yet very real battles, we understand how difficult it must be for you, and we care! You’re not the only one, and there’s nothing wrong in any ounce of what you’re feeling. Your feelings are valid.\n" +
                "\n" +
                "Taking an opportunity on this years’ World Mental Health Day, we urge everyone to be a little kind and a little more considerate towards everyone around. You never know how strong a storm your fellow mate is fighting.\n" +
                "\n" +
                "Love,\n" +
                "ELAD");
        ob1.setImg_logo(R.drawable.logo2);
        ob1.setImg_poster(R.drawable.poster2);
        ob1.setClubName("ELAD");
        holder.add(ob1);

        ModelFeed ob2=new ModelFeed();
        ob2.setTitle("World Sucide Prevention Day");
        ob2.setWriteUp("Even the Darkest night will end and the sun will rise.\n" +
                "Today is observed as 'World Suicide Prevention Day' to promote worldwide actions to prevent suicides and the factors causing them. There are nearly 3000 people on an average who die or commit suicide daily due to one or more reasons. \n" +
                "Many people who suffer from depression, anxiety and stress are afraid to talk about their feeling and problems, not because the problem is big but because of the thought of being judged by their friends, family and society. \n" +
                "Before calling someone a whiner for sharing his problems, show sympathy, understand his situation and try to empathize. Remember, \"A minute of your time can change someone's life.\"\n" +
                "Methods to stop suicide may include:\n" +
                "- Talking about mental status with less hesitation\n" +
                "-  Reducing risk factors for suicide, such as poverty, marital issues etc\n" +
                "- Teaching people how to deal with failure\n" +
                "- Stop judging people over their issues\n" +
                "And last but not the least,\n" +
                "- Giving people hope for a better life.\n" +
                "Remember, just when the caterpillar thought the world was over, it became a butterfly. Don't ever give up. Before you do so, think of why you held on for this long. \n" +
                "With so many calls to action of how to help someone who is thinking of suicide, I can’t help but think of how painful these reminders can be for someone who has already lost a loved one to suicide.\n" +
                "Whenever you feel like quitting,\n" +
                "“Place your hand over your heart, can you feel it?\n" +
                "That is called purpose.\n" +
                "You’re alive for a reason so don’t ever give up.”\n" +
                "Just know that, no matter how difficult the situation gets, Suicide is NEVER an option!\n" +
                "We at Spicmacay, NIT Kurukshetra hope that whatever you're going through right now, gets better soon. Every problem has a solution, you just need the mind to find it.\n" +
                "Suicide Helpline of India - +919152987821\n" +
                "Write-up - Vishakha Bagadi, Aarushi Hans\n" +
                "Poster - Paras Bansal");
        ob2.setImg_logo(R.drawable.logo1);
        ob2.setImg_poster(R.drawable.poster1);
        ob2.setClubName("Spicmacay");
        holder.add(ob2);

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
