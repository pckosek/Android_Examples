package com.example.pckosek.recyclerview_01;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mUsersList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mUsersAdapter = new UsersAdapter(mUsersList);

        RecyclerView.LayoutManager rvlManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(rvlManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mUsersAdapter);

        mUsersList.add( "User 1" );
        mUsersList.add( "User 2" );
        mUsersList.add( "User 3" );
        mUsersList.add( "User 4" );
        mUsersList.add( "User 5" );
        mUsersList.add( "User 6" );
        mUsersList.add( "User 7" );
        mUsersList.add( "User 8" );
        mUsersList.add( "User 9" );
        mUsersList.add( "Paul" );
        mUsersList.add( "Barb" );
        mUsersList.add( "Fred" );
        mUsersList.add( "Dad" );
        mUsersList.add( "Mom" );
        mUsersList.add( "Phil" );
        mUsersList.add( "Nate" );
        mUsersList.add( "Steve" );
        mUsersList.add( "Erin" );
        mUsersList.add( "Odin" );
        mUsersAdapter.notifyDataSetChanged();
    }
}
