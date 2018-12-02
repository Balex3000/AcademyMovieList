package com.balex.android.academymovielist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import static android.support.v4.content.ContextCompat.startActivity;


public class MovieViewAdapter extends RecyclerView.Adapter <MovieViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<MovieModel> mDataSource;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView ivImage;
        public final TextView tvTitle;
        public final TextView tvDesc;

        public ViewHolder (View view) {
            super(view);
            ivImage = view.findViewById(R.id.item_movie_iv);
            tvTitle = view.findViewById(R.id.tv_movie_title);
            tvDesc = view.findViewById(R.id.tv_movie_desc);
        }

        public void onBindViewHolder (MovieModel movieModel) {
            ivImage.setImageResource(movieModel.getImageResourceId());
            tvTitle.setText(movieModel.getTitle());
            tvDesc.setText(movieModel.getDesc());
        }
    }

    // Constructor
    public MovieViewAdapter (Context context, ArrayList<MovieModel> items) {
        mDataSource = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.onBindViewHolder(mDataSource.get(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), mDataSource.get(position).getTitle(), Toast.LENGTH_LONG).show();
                // Open MovieDetails activity
                Intent intent = new Intent(view.getContext(), MovieDetailsActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra("LIST", (Serializable) mDataSource);
                intent.putExtra("CurrentItem", position);
                startActivity(view.getContext(), intent, bundle);
            }
        });
    }
}
