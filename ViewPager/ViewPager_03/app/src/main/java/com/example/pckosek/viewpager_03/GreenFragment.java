package com.example.pckosek.viewpager_03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GreenFragment extends Fragment {


    public GreenFragment() {}

    public static GreenFragment newInstance() {
        GreenFragment fragment = new GreenFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green, container, false);
    }

}
