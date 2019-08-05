package com.example.pckosek.ui_example_02;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInterface{

    private static final String TAG = "MAIN_ACTIVITY";
    private ArrayList<MyUser> myUsers = new ArrayList<MyUser>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            int numUsers = myUsers.size();
            String msg = "You have " + String.valueOf(numUsers) + " users";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT ).show();
            Log.i(TAG, msg);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void assignNewUser(MyUser myUser) {
        myUsers.add(myUser);
    }
}