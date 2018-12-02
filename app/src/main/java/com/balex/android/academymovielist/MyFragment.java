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

    private static final String TAG_ARG_IMAGE_SMALL = "smallImgResId";
    private static final String TAG_ARG_IMAGE_LARGE = "largeImgResId";
    private static final String TAG_ARG_TITLE = "movieTitle";
    private static final String TAG_ARG_RELEASE = "releaseDate";
    private static final String TAG_ARG_DESC = "movieDesc";

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
        args.putInt (TAG_ARG_IMAGE_SMALL, pMovie.getImageResourceId());
        args.putString (TAG_ARG_TITLE, pMovie.getTitle());
        args.putString(TAG_ARG_DESC, pMovie.getDesc());
        args.putString(TAG_ARG_RELEASE, pMovie.getReleaseDate());
        args.putInt(TAG_ARG_IMAGE_LARGE, pMovie.getLargeImgResId());

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
            mMovie.setImageResourceId(getArguments().getInt(TAG_ARG_IMAGE_SMALL));
            mMovie.setTitle(getArguments().getString(TAG_ARG_TITLE));
            mMovie.setLargeImgResId(getArguments().getInt(TAG_ARG_IMAGE_LARGE));
            mMovie.setReleaseDate(getArguments().getString(TAG_ARG_RELEASE));
            mMovie.setDesc(getArguments().getString(TAG_ARG_DESC));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.view_pager_item, container, false);

        ImageView smallImg = view.findViewById(R.id.movie_det_small_img);
        smallImg.setImageResource(mMovie.getImageResourceId());

        TextView movieTitleTV = view.findViewById(R.id.movie_det_title_tv);
        movieTitleTV.setText(mMovie.getTitle());

        TextView releaseDateTV = view.findViewById(R.id.movie_det_release_tv);
        releaseDateTV.setText(mMovie.getReleaseDate());

        TextView movieDescTV = view.findViewById(R.id.movie_det_desc_tv);
        movieDescTV.setText(mMovie.getDesc());

        ImageView largeImg = view.findViewById(R.id.movie_det_large_img);
        largeImg.setImageResource(mMovie.getLargeImgResId());

        return view;
    }
}
