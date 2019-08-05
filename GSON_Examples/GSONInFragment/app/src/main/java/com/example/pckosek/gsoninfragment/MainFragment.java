package com.example.pckosek.gsoninfragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "MAIN_FRAGMENT";
    TextView mTextView;
    Button mButton;
    AllUsers mAllUsers;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         mButton   = view.findViewById(R.id.btn_next);
         mTextView = view.findViewById(R.id.tv_display);

         mButton.setOnClickListener(this);

         Gson gson = new GsonBuilder().create();
         mAllUsers = gson.fromJson( getString(R.string.all_users), AllUsers.class );

         Log.i(TAG, getString(R.string.all_users));
    }

    @Override
    public void onClick(View v) {
        mTextView.setText( mAllUsers.getNextName() );
    }
}