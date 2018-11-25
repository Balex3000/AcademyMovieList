package com.balex.android.academymovielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<MovieModel> mDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mDataSource = (ArrayList<MovieModel>) loadMovies();

        initRecyclerView();

        /*
        mListView = findViewById(R.id.movies_lv);

        MoviesBaseAdapter adapter = new MoviesBaseAdapter(this, mDataSource);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MovieModel movie = mDataSource.get(position);
                Toast.makeText(view.getContext(), movie.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        */
    }

    private void initRecyclerView () {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovieViewAdapter(this, mDataSource);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<MovieModel> loadMovies() {
        List<MovieModel> movies = new ArrayList<>(9);

        MovieModel movie1 = new MovieModel();
        MovieModel movie2 = new MovieModel();
        MovieModel movie3 = new MovieModel();
        MovieModel movie4 = new MovieModel();
        MovieModel movie5 = new MovieModel();
        MovieModel movie6 = new MovieModel();
        MovieModel movie7 = new MovieModel();
        MovieModel movie8 = new MovieModel();
        MovieModel movie9 = new MovieModel();

        movie1.setTitle("Jurassic World - Fallen Kingdom");
        movie2.setTitle("The Meg");
        movie3.setTitle("The First Purge");
        movie4.setTitle("Deadpool 2");
        movie5.setTitle("Black Panther");
        movie6.setTitle("Ocean's Eight");
        movie7.setTitle("Interstellar");
        movie8.setTitle("Thor - Ragnarok");
        movie9.setTitle("Guardians of the Galaxy");

        movie1.setImageResourceId(R.drawable.jurasic_park);
        movie2.setImageResourceId(R.drawable.the_meg);
        movie3.setImageResourceId(R.drawable.the_first_purge);
        movie4.setImageResourceId(R.drawable.deadpool2);
        movie5.setImageResourceId(R.drawable.blackpanther);
        movie6.setImageResourceId(R.drawable.oceans8);
        movie7.setImageResourceId(R.drawable.interstellar);
        movie8.setImageResourceId(R.drawable.thor_ragnarock);
        movie9.setImageResourceId(R.drawable.guardians_of_the_galaxy);

        movie1.setDesc("Three years after the Jurassic World theme park was closed down, Owen and Claire return to Isla Nublar to save the dinosaurs when they learn that a once dormant volcano on the island is active and is threatening to extinguish all life there. Along the way, Owen sets out to find Blue, his lead raptor, and discovers a conspiracy that could disrupt the natural order of the entire planet. Life has found a way, again.");
        movie2.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie3.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie4.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie5.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie6.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie7.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie8.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");
        movie9.setDesc("Five years ago, expert sea diver and Naval Captain Jonas Taylor encountered an unknown danger in the unexplored recesses of the Mariana Trench that forced him to abort his mission and abandon half his crew. Though the tragic incident earned him a dishonorable discharge, what ultimately cost him his career, his marriage and any semblance of honor was his unsupported and incredulous claims of what caused it - an attack on his vessel by a mammoth, 70-foot sea creature, believed to be extinct for more than a million years.");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);
        movies.add(movie8);
        movies.add(movie9);

        return movies;
    }
}
