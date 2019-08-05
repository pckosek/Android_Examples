package com.example.pckosek.dynamiclayout_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mMyLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyLinearLayout = findViewById(R.id.ll_dynamic);

        setupViews();
    }

    protected void setupViews() {
        Button b1 = new Button(this);
        b1.setText("Hi, I'm a Button");
        b1.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        mMyLinearLayout.addView(b1);
    }
}
