package com.balex.android.academymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

        /* regular list view

        View rowItem = mInflater.inflate(R.layout.item_movie, parent, false);

        ImageView img = rowItem.findViewById(R.id.item_movie_iv);
        TextView title = rowItem.findViewById(R.id.tv_movie_title);
        TextView desc = rowItem.findViewById(R.id.tv_movie_desc);
        */

        // new approach
        MovieViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_movie, parent, false);
            // approach 2.2 with view holder
            holder = new MovieViewHolder();
            holder.image = convertView.findViewById(R.id.item_movie_iv);
            holder.title = convertView.findViewById(R.id.tv_movie_title);
            holder.desc = convertView.findViewById(R.id.tv_movie_desc);
            convertView.setTag(holder);
        } else {
            // part of aproach 2.2
            holder = (MovieViewHolder) convertView.getTag();
        }

        // approach 2.1
        /*
        ImageView img = convertView.findViewById(R.id.item_movie_iv);
        TextView title = convertView.findViewById(R.id.tv_movie_title);
        TextView desc = convertView.findViewById(R.id.tv_movie_desc);
        */

        // Get data for this specific row
        MovieModel movie = getItem(pPosition);

        // Fill our view with our data
        // approach v1 and 2.1
        /*
        img.setImageResource(movie.getImageResourceId());
        title.setText(movie.getTitle());
        desc.setText(movie.getDesc());
        */

        // approach 2.2 with view holder
        holder.image.setImageResource(movie.getImageResourceId());
        holder.title.setText(movie.getTitle());
        holder.desc.setText(movie.getDesc());

        // regular list view approach
        //return rowItem;

        // new approach 2.1 and 2.2
        return convertView;
    }
}
