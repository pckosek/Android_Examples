package com.example.pckosek.recyclerview_03;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDialogFragment extends DialogFragment {

    private final static String ARGS_USER = "args_user";

    private TextView mTextView;

    public MyDialogFragment() {}

    public static MyDialogFragment newInstance(MyUser usr) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle args = new Bundle();

        args.putSerializable(ARGS_USER, usr);
        myDialogFragment.setArguments(args);
        return myDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MyUser myUser = (MyUser) getArguments().getSerializable(ARGS_USER);

        mTextView = view.findViewById(R.id.tv_count);
        mTextView.setText( myUser.name );
    }
}
