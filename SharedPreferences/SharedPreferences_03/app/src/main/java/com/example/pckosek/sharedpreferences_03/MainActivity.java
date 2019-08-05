package com.example.pckosek.sharedpreferences_03;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInterface{

    private static final String TAG = "MAIN_ACTIVITY";
    private static final String STORAGE_KEY = "stored_count";

    private int mCount;
    private SharedPreferences.Editor mEditor;

    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mySharedPrefs = getSharedPreferences(
                "Storage",
                Context.MODE_PRIVATE);
        mEditor = mySharedPrefs.edit();

        mCount = mySharedPrefs.getInt(STORAGE_KEY, 0);

        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frag_main);
        mMainFragment.UpdateDisplay(mCount);

    }

    @Override
    public void ButtonPressEvent() {
        mCount++;
        mEditor.putInt(STORAGE_KEY,mCount);
        mEditor.apply();

        mMainFragment.UpdateDisplay(mCount);
    }
}
