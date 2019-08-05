package com.example.pckosek.notificationdialog_01;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyDialogFragment extends DialogFragment {

    private final static String ARGS_COUNT = "args_count";

    private TextView mTextView;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    public static MyDialogFragment newInstance(int i) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle args = new Bundle();

        args.putInt(ARGS_COUNT, i);
        myDialogFragment.setArguments(args);
        return myDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int count = getArguments().getInt(ARGS_COUNT, 0);

        mTextView = view.findViewById(R.id.tv_count);
        mTextView.setText( String.valueOf(count) );
    }
}
