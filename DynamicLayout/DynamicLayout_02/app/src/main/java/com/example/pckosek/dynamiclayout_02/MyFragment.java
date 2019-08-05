package com.example.pckosek.dynamiclayout_02;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class MyFragment extends Fragment implements View.OnClickListener {

    LinearLayout mLLContent;
    Button mButtonCreate;

    public MyFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButtonCreate = view.findViewById(R.id.btn_create);
        mLLContent = view.findViewById(R.id.ll_content);

        mButtonCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        addView();
    }

    protected void addView() {
        Random rand = new Random();

        int rand_R = rand.nextInt(256);
        int rand_G = rand.nextInt(256);
        int rand_B = rand.nextInt(256);

        int rand_Color = Color.argb(255, rand_R, rand_G, rand_B);

        View v = new View(getContext());
        v.setBackgroundColor(rand_Color);
        v.setLayoutParams(new ViewGroup.LayoutParams(
                100,
                100));

        mLLContent.addView(v);
    }
}
