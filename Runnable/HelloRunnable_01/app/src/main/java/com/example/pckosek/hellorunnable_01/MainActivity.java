package com.example.pckosek.hellorunnable_01;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton;
    TextView mTextView;

    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn_start);
        mTextView = findViewById(R.id.tv_display);

        mButton.setOnClickListener(this);

        mHandler = new Handler();

    }

    @Override
    public void onClick(View v) {

        mHandler.postDelayed(new MyRunnable(), 1000);

    }

    public class MyRunnable implements Runnable {

        @Override
        public void run() {
            Random r = new Random();
            int rand_num = r.nextInt(11);

            mTextView.setText(Integer.toString(rand_num));
        }
    }
}
