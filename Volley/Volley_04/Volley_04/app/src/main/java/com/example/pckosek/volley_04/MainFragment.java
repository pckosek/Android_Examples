package com.example.pckosek.volley_04;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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


public class MainFragment extends Fragment implements View.OnClickListener {

    private TextView mTextViewName;
    private TextView getmTextViewAge;
    private Button mButtonGet;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextViewName = view.findViewById(R.id.tv_user_name);
        getmTextViewAge = view.findViewById(R.id.tv_user_age);
        mButtonGet = view.findViewById(R.id.btn_get);
        mButtonGet.setOnClickListener(this);
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

    protected class MyResponseHelper implements
            Response.Listener<String>, Response.ErrorListener {

        @Override
        public void onResponse(String response) {
            Gson gson = new GsonBuilder().create();
            MyUser myUser = gson.fromJson(response, MyUser.class);

            mTextViewName.setText( myUser.name );
            getmTextViewAge.setText( String.valueOf(myUser.age) );
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
        }
    }
}