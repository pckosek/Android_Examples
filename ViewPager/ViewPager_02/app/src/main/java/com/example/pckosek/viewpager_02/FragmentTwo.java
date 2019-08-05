package com.example.pckosek.viewpager_02;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTwo extends Fragment {

    public static final String ARG_MY_USER = "my_user";

    private TextView mTextViewName;
    private TextView mTextViewAge;

    public FragmentTwo() {}

    public static FragmentTwo newInstance(MyUser myUser) {
        FragmentTwo fragment = new FragmentTwo();

        Bundle args = new Bundle();
        args.putSerializable(ARG_MY_USER, myUser);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyUser myUser = (MyUser) getArguments().getSerializable(ARG_MY_USER);

        mTextViewAge = view.findViewById(R.id.tv_age);
        mTextViewName = view.findViewById(R.id.tv_name);

        mTextViewName.setText( myUser.name );
        mTextViewAge.setText( String.valueOf(myUser.age));
    }
}