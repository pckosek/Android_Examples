package com.example.pckosek.viewpager_02;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.pckosek.viewpager_02.FragmentOne.ARG_MY_USERS;

public class MainActivity extends AppCompatActivity {

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ViewPager mViewPager;

    ArrayList<MyUser> mAllUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Gson gson = new GsonBuilder().create();
        MyUser[] myUsers = gson.fromJson(getString(R.string.my_users), MyUser[].class );

        mAllUsers = new ArrayList<MyUser>(Arrays.asList(myUsers));

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment;
            MyUser[] users;

            switch (position) {
                case 0 :
                    users = new MyUser[mAllUsers.size()];
                    users = mAllUsers.toArray(users);
                    fragment = FragmentOne.newInstance( users );
                    break;
                case 1 :
                    fragment = FragmentTwo.newInstance(mAllUsers.get(0));
                    break;


                case 2 :
                    fragment = FragmentTwo.newInstance(mAllUsers.get(mAllUsers.size()-1));
                    break;
                default :
                    users = new MyUser[mAllUsers.size()];
                    users = mAllUsers.toArray(users);
                    fragment = FragmentOne.newInstance( users );
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}