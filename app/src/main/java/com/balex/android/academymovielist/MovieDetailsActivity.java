package com.balex.android.academymovielist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

        TextView tvMovieTitle = findViewById(R.id.movie_det_title_tv);
        tvMovieTitle.setText(mDataSource.get(currentItem).getTitle());
    }
}
