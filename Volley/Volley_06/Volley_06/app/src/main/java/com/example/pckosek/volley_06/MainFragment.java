package com.example.pckosek.volley_06;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class MainFragment extends Fragment {

    private LinearLayout mLinearLayout;
    private MyErrorHelper myErrorHelper;
    private SeekBar mSeekbar;

    public MainFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLinearLayout = view.findViewById(R.id.layout_linear);
        mSeekbar = view.findViewById(R.id.seekBar);
        myErrorHelper = new MyErrorHelper();

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (mLinearLayout.getChildCount() > 0) {
                    mLinearLayout.removeAllViews();
                }

                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("user.tjhsst.edu")
                        .appendPath("pckosek")
                        .appendQueryParameter("count", String.valueOf(progress));

                String url = builder.build().toString();
                MyResponseHelper myResponseHelper = new MyResponseHelper();
                StringRequest myStringRequest= new StringRequest(
                        url,
                        myResponseHelper,
                        myErrorHelper);

                RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                requestQueue.getCache().clear();
                requestQueue.add(myStringRequest);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    protected void processUsers(String s) {
        Gson gson = new GsonBuilder().create();
        MyPhotoUser[] myPhotoUsers = gson.fromJson(s, MyPhotoUser[].class);

        LayoutInflater inflater = LayoutInflater.from(getContext());

        int dp_width = 250;
        int px_width =  Math.round( dp_width * getResources().getDisplayMetrics().density );

        int dp_height = 125;
        int px_height =  Math.round( dp_height * getResources().getDisplayMetrics().density );

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                px_width,
                px_height);
        params.setMargins(16,16,16,16);

        for (int i=0; i< myPhotoUsers.length; i++) {
            ConstraintLayout layout_this = (ConstraintLayout) inflater.inflate(
                    R.layout.single_item, null, false);
            layout_this.setLayoutParams(params);

            TextView textViewName = layout_this.findViewById(R.id.tv_name);
            textViewName.setText(myPhotoUsers[i].name);

            MySingleItemListener mySingleItemListener = new MySingleItemListener(layout_this);

            ImageRequest imageRequest = new ImageRequest(
                    myPhotoUsers[i].photoUrl,
                    mySingleItemListener,
                    250,
                    250, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565,
                    myErrorHelper);

            imageRequest.setShouldCache(false);
            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(imageRequest);

            mLinearLayout.addView(layout_this);
        }

    }


    protected class MySingleItemListener implements Response.Listener<Bitmap> {

        private ConstraintLayout constraintLayout;

        public MySingleItemListener(ConstraintLayout c) {
            constraintLayout = c;
        }

        @Override
        public void onResponse(Bitmap response) {
            ImageView imageView = constraintLayout.findViewById(R.id.image_profile);
            imageView.setImageBitmap(response);

            ProgressBar progressBar = constraintLayout.findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);
        }
    }

    protected class MyResponseHelper implements Response.Listener<String> {

        @Override
        public void onResponse(String response) {
            processUsers(response);
        }
    }

    protected class MyErrorHelper implements Response.ErrorListener {

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
        }
    }


}
