package com.example.pckosek.sharedpreferences_02;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainFragment extends Fragment {

    private static final String TAG = "MAIN_FRAGMENT";
    private static final String STORAGE_KEY = "stored_count";

    Button mButton;
    TextView mTextView;
    private int mCount;
    private SharedPreferences.Editor mEditor;

    public MainFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextView = view.findViewById(R.id.tv_display);
        mButton   = view.findViewById(R.id.btn_count);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncrementAndUpdateTextDisplay();
            }
        });

        SharedPreferences mySharedPrefs = getActivity().getSharedPreferences(
                "Storage",
                Context.MODE_PRIVATE);
        mEditor = mySharedPrefs.edit();

        int storedCount = mySharedPrefs.getInt(STORAGE_KEY, 0);

        mCount = storedCount;
        mTextView.setText( Integer.toString(mCount) );

    }

    public void IncrementAndUpdateTextDisplay() {
        mCount++;
        mTextView.setText( Integer.toString(mCount) );
        mEditor.putInt(STORAGE_KEY, mCount);
        mEditor.apply();
    }

}
