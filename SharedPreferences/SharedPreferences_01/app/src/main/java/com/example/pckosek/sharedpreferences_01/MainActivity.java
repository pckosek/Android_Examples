package com.example.pckosek.sharedpreferences_01;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN_ACTIVITY";
    private static final String STORAGE_KEY = "stored_count";

    Button mButton;
    TextView mTextView;
    private int mCount;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv_display);
        mButton   = findViewById(R.id.btn_count);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncrementAndUpdateTextDisplay();
            }
        });

        SharedPreferences mySharedPrefs = getSharedPreferences("Storage", Context.MODE_PRIVATE);
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