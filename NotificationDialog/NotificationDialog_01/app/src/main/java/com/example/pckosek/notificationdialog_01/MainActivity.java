package com.example.pckosek.notificationdialog_01;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButton;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn_notification);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mCount++;

        FragmentManager fm = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(mCount);
        myDialogFragment.show(fm, "fragment_my_dialog");


    }
}
