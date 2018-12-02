package com.balex.android.academymovielist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {

    ArrayList<MovieModel> mDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        Intent intent = getIntent();
        mDataSource = (ArrayList<MovieModel>) intent.getSerializableExtra("LIST");
        int currentItem = intent.getIntExtra ("CurrentItem", 0);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), mDataSource));
        viewPager.setCurrentItem(currentItem);

    }

    protected class MyViewPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<MovieModel> moviesList;

        MyViewPagerAdapter(FragmentManager fm, ArrayList<MovieModel> movies) {
            super(fm);
            moviesList = movies;
        }

        @Override
        public int getCount() {
            return moviesList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return MyFragment.newInstance(moviesList.get(position));
        }
    }
}
