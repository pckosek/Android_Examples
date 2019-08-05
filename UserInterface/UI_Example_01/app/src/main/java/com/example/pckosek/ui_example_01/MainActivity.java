package com.example.pckosek.ui_example_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "MAIN_ACTIVITY";

    private EditText mEditText;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText    = findViewById(R.id.etxt_entry);
        mTextView    = findViewById(R.id.tv_display);

        MyTextWatcher myTextWatcher = new MyTextWatcher();

        mEditText.addTextChangedListener(myTextWatcher);
    }

    public class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 0) {

                mTextView.setText(String.valueOf(s.charAt(s.length() - 1)));
            } else {
                mTextView.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }
}
