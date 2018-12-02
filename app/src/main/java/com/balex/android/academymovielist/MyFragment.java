package com.balex.android.academymovielist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyFragment extends Fragment {

    private static final String TAG_ARG_IMAGE = "drawableResId";
    private static final String TAG_ARG_TITLE = "FruitTitle";

    private int imageResId;

    private MovieModel mMovie;

    /**
     * Use this factory method to create a new instance
     * of this fragment using a provided parameter
     *
     * @return A new instance of fragment
     */

    public static MyFragment newInstance(MovieModel pMovie) {

        MyFragment myFragment = new MyFragment();

        Bundle args = new Bundle();
        args.putInt (TAG_ARG_IMAGE, pMovie.getImageResourceId());
        args.putString (TAG_ARG_TITLE, pMovie.getTitle());

        myFragment.setArguments(args);

        return myFragment;
    }

    public MyFragment() {
        // required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // *** imageResId = getArguments() != null ? getArguments().getInt(TAG_ARG_IMAGE) : 0;
        if (getArguments() != null) {
            mMovie = new MovieModel();
            mMovie.setImageResourceId(getArguments().getInt(TAG_ARG_IMAGE));
            mMovie.setTitle(getArguments().getString(TAG_ARG_TITLE));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.view_pager_item, container, false);
        ImageView imageView = view.findViewById(R.id.movie_det_small_img);
        //***imageView.setImageResource(imageResId);
        imageView.setImageResource(mMovie.getImageResourceId());
        TextView textView = view.findViewById(R.id.movie_det_title_tv);
        textView.setText(mMovie.getTitle());

        return view;
    }
}
