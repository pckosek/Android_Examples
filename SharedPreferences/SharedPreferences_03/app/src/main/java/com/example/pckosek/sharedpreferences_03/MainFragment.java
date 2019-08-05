package com.example.pckosek.sharedpreferences_03;


import android.content.Context;
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

    private Button mButton;
    private TextView mTextView;

    private MainFragmentInterface mCallback;

    public MainFragment() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragment.MainFragmentInterface) {
            mCallback = (MainFragment.MainFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " [probably MainActivity] does not implement MainFragmentInterface!!!");
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

        mTextView = view.findViewById(R.id.tv_display);
        mButton   = view.findViewById(R.id.btn_count);



        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.ButtonPressEvent();
            }
        });
    }

    public void UpdateDisplay(int count) {
        mTextView.setText( Integer.toString(count) );
    }

    public interface MainFragmentInterface {
        void ButtonPressEvent();
    }

}
