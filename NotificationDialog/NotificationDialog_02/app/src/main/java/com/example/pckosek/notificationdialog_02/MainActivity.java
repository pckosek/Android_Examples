package com.example.pckosek.notificationdialog_02;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSubmitMessage(String msg) {
        FragmentManager fm = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(msg);
        myDialogFragment.show(fm, "fragment_my_dialog");

    }
}
