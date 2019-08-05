package com.example.pckosek.recyclerview_03;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        UsersAdapter.UsersAdapterInterface {

    private List<MyUser> mUsersList;
    private RecyclerView mRecyclerView;
    private UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new GsonBuilder().create();
        MyUser[] myUsers = gson.fromJson(getString(R.string.my_users), MyUser[].class);
        mUsersList = new ArrayList<>(Arrays.asList(myUsers));

        mRecyclerView = findViewById(R.id.recycler_view);
        mUsersAdapter = new UsersAdapter(mUsersList, this);
        mUsersAdapter.notifyDataSetChanged();

        RecyclerView.LayoutManager rvlManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(rvlManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mUsersAdapter);

    }





    @Override
    public void onEditItemClicked(View v, int pos) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(pos));
        popup.inflate(R.menu.menu_edit);
        popup.show();
    }


    public class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        private int position;

        public MyMenuItemClickListener(int pos) {
            this.position = pos;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_edit_item:
                    FragmentManager fm = getSupportFragmentManager();
                    MyDialogFragment myDialogFragment = MyDialogFragment.newInstance(
                            mUsersList.get(position));
                    myDialogFragment.show(fm, "fragment_my_dialog");
                    return true;

                default:
                    return false;
            }
        }
    }
}

