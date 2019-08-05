package com.example.pckosek.viewpager_03;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyViewPagerAdapter mMyViewPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mMyViewPagerAdapter);

    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) { super(fm);  }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;

            switch (position) {
                case 0 :
                    fragment = RedFragment.newInstance();
                    Toast.makeText(getApplicationContext(), "RED", Toast.LENGTH_SHORT).show();
                    break;
                case 1 :
                    fragment = GreenFragment.newInstance();
                    Toast.makeText(getApplicationContext(), "GREEN", Toast.LENGTH_SHORT).show();
                    break;
                case 2 :
                    fragment = BlueFragment.newInstance();
                    Toast.makeText(getApplicationContext(), "BLUE", Toast.LENGTH_SHORT).show();
                    break;
                default :
                    fragment = RedFragment.newInstance();
                    Toast.makeText(getApplicationContext(), "DEFAULT", Toast.LENGTH_SHORT).show();
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
