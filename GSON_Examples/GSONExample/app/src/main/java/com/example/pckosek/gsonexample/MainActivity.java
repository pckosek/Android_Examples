package com.example.pckosek.gsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv_01);

        Gson gson = new GsonBuilder().create();
        DummyUser myDummyUser = gson.fromJson( "{ age:17, name: \"Bob\" }", DummyUser.class);

        mTextView.setText( myDummyUser.name );

    }

    public class DummyUser {
        public int age;
        public String name;
    }
}
