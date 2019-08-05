package com.example.pckosek.volley_05;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainFragment extends Fragment implements View.OnClickListener{

    private Button mButton;
    private LinearLayout mLinearLayout;

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

        mButton = view.findViewById(R.id.btn_get);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = "https://user.tjhsst.edu/pckosek/";
        MyResponseHelper myResponseHelper = new MyResponseHelper();
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                myResponseHelper,
                myResponseHelper);

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    protected void updateViews(String s) {

        Gson gson = new GsonBuilder().create();
        MyUser[] myUsers = gson.fromJson(s, MyUser[].class);

        LayoutInflater inflater = LayoutInflater.from(getContext());

        int dp_width = 250;
        int px_width =  Math.round( dp_width * getResources().getDisplayMetrics().density );

        int dp_height = 75;
        int px_height =  Math.round( dp_height * getResources().getDisplayMetrics().density );

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                px_width,
                px_height);
        params.setMargins(16,16,16,16);


        for (int i=0; i<myUsers.length; i++) {
            ConstraintLayout layout_this = (ConstraintLayout) inflater.inflate(
                    R.layout.single_item, null, false);

            TextView tv_name = layout_this.findViewById(R.id.tv_name);
            TextView tv_age  = layout_this.findViewById(R.id.tv_age);

            tv_name.setText( myUsers[i].name );
            tv_age.setText( String.valueOf( myUsers[i].age ) );

            layout_this.setLayoutParams(params);

            mLinearLayout.addView(layout_this);
        }

    }

    protected class MyResponseHelper implements
            Response.Listener<String>, Response.ErrorListener {

        @Override
        public void onResponse(String response) {
            updateViews(response);
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
