package com.example.pckosek.notificationdialog_02;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainFragment extends Fragment implements View.OnClickListener {

    private MainFragmentListener mCallback;

    private Button mButton;
    private TextInputLayout mTextInputLayout;
    private EditText mEditText;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentListener) {
            mCallback = (MainFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "[probably your MainActivity] must implement MainFragmentListener");
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

        mTextInputLayout = view.findViewById(R.id.text_input_layout);

        mButton = view.findViewById(R.id.btn_notification);
        mButton.setOnClickListener(this);

        mEditText = view.findViewById(R.id.et_message);
        mEditText.addTextChangedListener(new MyTextWatcher());
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public void onClick(View v) {
        String msg = validateInput();
        if (msg != null) {
            mCallback.onSubmitMessage(msg);
        }
    }

    protected String validateInput() {
        String msg = mEditText.getText().toString();

        if (msg.length()==0 ) {
            mTextInputLayout.setError("Please Enter a Message");
            msg = null;
        }
        return msg;
    }

    public interface MainFragmentListener {
        void onSubmitMessage(String msg);
    }

    protected class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mTextInputLayout.setError(null);
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }
}
