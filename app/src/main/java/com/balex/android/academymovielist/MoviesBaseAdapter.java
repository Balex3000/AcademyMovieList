package com.balex.android.academymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MoviesBaseAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<MovieModel> mDataSource;

    public MoviesBaseAdapter (Context pContext, ArrayList<MovieModel> pItems) {
        mDataSource = pItems;
        mInflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MovieModel getItem(int pPosition) {
        return mDataSource.get(pPosition);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public long getItemId(int pPosition) {
        return pPosition;
    }

    @Override
    public View getView(int pPosition, View convertView, ViewGroup parent) {
        // Inflate our row and find our views
        View rowItem = mInflater.inflate(R.layout.item_movie, parent, false);

        ImageView img = rowItem.findViewById(R.id.item_movie_iv);
        TextView title = rowItem.findViewById(R.id.tv_movie_title);
        TextView desc = rowItem.findViewById(R.id.tv_movie_desc);

        // Get data for this specific row
        MovieModel movie = getItem(pPosition);

        // Fill our view with our data
        img.setImageResource(movie.getImageResourceId());
        title.setText(movie.getTitle());
        desc.setText(movie.getDesc());

        return rowItem;
    }
}
