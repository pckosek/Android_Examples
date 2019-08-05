package com.example.pckosek.viewpager_02;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FragmentOne extends Fragment {

    private static final String TAG = "FRAGMENT_ONE";
    public static final String ARG_MY_USERS = "my_users";
    private LinearLayout mLLayout;


    public FragmentOne() {}

    public static FragmentOne newInstance(MyUser[] myUsers) {
        FragmentOne fragment = new FragmentOne();

        Bundle args = new Bundle();
        args.putSerializable(ARG_MY_USERS, myUsers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "onviewcreated");

        mLLayout = view.findViewById(R.id.ll_container);

        MyUser[] myUsers = (MyUser[]) getArguments().getSerializable(ARG_MY_USERS);
        updateDisplay(myUsers);

    }


    public void updateDisplay(MyUser[] myUsers){

        Log.i(TAG, ""+ myUsers.length);

        for (int i=0; i<myUsers.length; i++) {
            LinearLayout ll_text = new LinearLayout(getContext());
            ll_text.setOrientation(LinearLayout.VERTICAL);
            ll_text.setBackgroundColor( getResources().getColor(R.color.ll_color));
            LinearLayout.LayoutParams ll_params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            ll_params.setMargins(40,40,40,40);
            ll_text.setLayoutParams(ll_params);


            TextView tvName = new TextView(getContext());
            tvName.setText("Name: " + myUsers[i].name);
            LinearLayout.LayoutParams params_name = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tvName.setLayoutParams(params_name);

            TextView tvAge = new TextView(getContext());
            tvAge.setText("Age: " + String.valueOf(myUsers[i].age));
            LinearLayout.LayoutParams params_age = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tvAge.setLayoutParams(params_age);

            ll_text.addView(tvName);
            ll_text.addView(tvAge);

            mLLayout.addView(ll_text);
        }
    }
}
