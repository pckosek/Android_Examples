package com.example.pckosek.viewpager_01;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

    private static final String ARG_USER_N = "user_n";

    public MainFragment() {}

    public static MainFragment newInstance(MyUser myUser) {
        MainFragment fragment = new MainFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_USER_N, myUser);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyUser myUser = (MyUser) getArguments().getSerializable(ARG_USER_N);

        TextView textViewName = view.findViewById(R.id.tv_name);
        TextView textViewAge  = view.findViewById(R.id.tv_age);

        textViewName.setText(myUser.name);
        textViewAge.setText( String.valueOf(myUser.age) );
    }
}
