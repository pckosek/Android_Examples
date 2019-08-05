package com.example.pckosek.notificationdialog_02;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyDialogFragment extends DialogFragment {

    private final static String ARGS_MESSAGE = "args_message";

    private TextView mTextView;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    public static MyDialogFragment newInstance(String msg) {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle args = new Bundle();

        args.putString(ARGS_MESSAGE, msg);
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

        String msg = getArguments().getString(ARGS_MESSAGE, "");

        mTextView = view.findViewById(R.id.tv_count);
        mTextView.setText( msg );
    }
}
