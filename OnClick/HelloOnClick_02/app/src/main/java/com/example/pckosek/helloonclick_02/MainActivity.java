package com.example.pckosek.helloonclick_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MAIN_ACTIVITY";
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn_hello);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "clicked the button");
    }
}
