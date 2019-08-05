package com.example.pckosek.ui_example_02;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class MainFragment extends Fragment {

    private static final String TAG = "MAIN_FRAGMENT";

    private EditText mEditTextName;
    private EditText mEditTextAge;

    private MainFragmentInterface mCallback;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragment.MainFragmentInterface) {
            mCallback = (MainFragment.MainFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " does not implement MainFragmentInterface!!!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEditTextName = view.findViewById(R.id.et_name);
        mEditTextAge = view.findViewById(R.id.et_age);

        FloatingActionButton fab = view.findViewById(R.id.fab_01);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyUser myUser = validateInput();
                if ( myUser != null ) {
                    mCallback.assignNewUser(myUser);
                }
            }
        });

    }

    protected MyUser validateInput() {

        boolean nameOkay = false;
        boolean ageOkay = false;
        MyUser myUser;

        String name = mEditTextName.getText().toString();
        if (name.length() == 0 ) {
            mEditTextName.setError("Name must not be empty");
        } else {
            nameOkay = true;
        }

        String ageString  = mEditTextAge.getText().toString();
        if (ageString.length() == 0 ) {
            mEditTextAge.setError("Age must not be empty");
        } else {
            ageOkay = true;
        }

        if (nameOkay && ageOkay) {
            myUser = new MyUser( name, Integer.valueOf(ageString) );
            mEditTextAge.setText("");
            mEditTextName.setText("");

            String successMsg = "Added User: " + myUser.toJson();
            Toast.makeText(getContext(), successMsg, Toast.LENGTH_SHORT ).show();

        } else {
            myUser = null;
        }

        return myUser;

    }

    public interface MainFragmentInterface {
        void assignNewUser(MyUser myUser);
    }

}