package com.example.pckosek.dynamiclayout_03;


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
                200,
                200));

        LinearLayout ll_text = new LinearLayout(getContext());
        ll_text.setOrientation(LinearLayout.HORIZONTAL);
        ll_text.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView tv_r = new TextView(getContext());
        tv_r.setText( "R: " + String.valueOf(rand_R) );
        LinearLayout.LayoutParams params_r = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params_r.setMarginEnd(40);
        tv_r.setLayoutParams(params_r);

        TextView tv_g = new TextView(getContext());
        tv_g.setText( "G: " + String.valueOf(rand_R) );
        LinearLayout.LayoutParams params_g = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params_g.setMarginEnd(40);
        tv_g.setLayoutParams(params_g);

        TextView tv_b = new TextView(getContext());
        tv_b.setText( "B: " + String.valueOf(rand_R) );
        LinearLayout.LayoutParams params_b = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params_b.setMarginEnd(40);
        tv_b.setLayoutParams(params_b);

        ll_text.addView(tv_r);
        ll_text.addView(tv_g);
        ll_text.addView(tv_b);

        LinearLayout ll_item = new LinearLayout(getContext());
        ll_item.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params_ll =  new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params_ll.setMarginEnd(50);
        ll_item.setLayoutParams(params_ll);

        ll_item.addView(v);
        ll_item.addView(ll_text);

        mLLContent.addView(ll_item);
    }
}