package com.balex.android.academymovielist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

//import static android.support.v4.content.ContextCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    ArrayList<MovieModel> mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDataSource = (ArrayList<MovieModel>) loadMovies();

        initRecyclerView();
    }

    private void initRecyclerView () {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new MovieViewAdapter(this, mDataSource);
        mRecyclerView.setAdapter(mAdapter);
    }

    /** Inflate menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /** Treat click on menu options */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_async) {
            Intent intent = new Intent(getApplicationContext(), AsyncActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_thread) {
            Intent intent = new Intent(getApplicationContext(), ThreadActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_service) {
            Intent intent = new Intent(getApplicationContext(), BGServiceActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Log.d("Alex","in MainActivity.onSaveInstanceState");
        super.onSaveInstanceState(outState);
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

        movie1.setImageResourceId(R.drawable.jurasic_park_small);
        movie2.setImageResourceId(R.drawable.the_meg_small);
        movie3.setImageResourceId(R.drawable.the_first_purge_small);
        movie4.setImageResourceId(R.drawable.deadpool2_small);
        movie5.setImageResourceId(R.drawable.blackpanther_small);
        movie6.setImageResourceId(R.drawable.oceans8_small);
        movie7.setImageResourceId(R.drawable.interstellar_small);
        movie8.setImageResourceId(R.drawable.thor_ragnarock_small);
        movie9.setImageResourceId(R.drawable.guardians_of_the_galaxy_small);

        movie1.setDesc("When the island's dormant volcano begins roaring to life, Owen and Claire mount a campaign to rescue the remaining dinosaurs from this extinction-level event.");
        movie2.setDesc("After escaping an attack by what he claims was a 70-foot shark, Jonas Taylor must confront his fears to save those trapped in a sunken submersible.");
        movie3.setDesc("America's third political party, the New Founding Fathers of America, comes to power and conducts an experiment: no laws for 12 hours on Staten Island. No one has to stay on the island, but $5,000 is given to anyone who does.");
        movie4.setDesc("Foul-mouthed mutant mercenary Wade Wilson (AKA. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg, Cable.");
        movie5.setDesc("T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country's past.");
        movie6.setDesc("Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City's yearly Met Gala.");
        movie7.setDesc("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        movie8.setDesc("Thor is imprisoned on the planet Sakaar, and must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela.");
        movie9.setDesc("A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.");

        movie1.setReleaseDate("22/06/2018");
        movie2.setReleaseDate("10/08/2018");
        movie3.setReleaseDate("04/07/2018");
        movie4.setReleaseDate("18/05/2018");
        movie5.setReleaseDate("16/02/2018");
        movie6.setReleaseDate("08/06/2018");
        movie7.setReleaseDate("07/11/2014");
        movie8.setReleaseDate("03/11/2017");
        movie9.setReleaseDate("01/08/2014");

        movie1.setLargeImgResId(R.drawable.jurassicworld2_large);
        movie2.setLargeImgResId(R.drawable.the_meg_large);
        movie3.setLargeImgResId(R.drawable.the_first_purge_large);
        movie4.setLargeImgResId(R.drawable.deadpool2_large);
        movie5.setLargeImgResId(R.drawable.black_panther_large);
        movie6.setLargeImgResId(R.drawable.oceans8_large);
        movie7.setLargeImgResId(R.drawable.interstellar_large);
        movie8.setLargeImgResId(R.drawable.thor_ragnarok_large);
        movie9.setLargeImgResId(R.drawable.guardians_of_the_galaxy_large);

        movie1.setTrailerURL("https://www.youtube.com/watch?v=vn9mMeWcgoM");
        movie2.setTrailerURL("https://www.youtube.com/watch?v=bsLk0NPRFAc");
        movie3.setTrailerURL("https://www.youtube.com/watch?v=UL29y0ah92w");
        movie4.setTrailerURL("https://www.youtube.com/watch?v=D86RtevtfrA");
        movie5.setTrailerURL("https://www.youtube.com/watch?v=xjDjIWPwcPU");
        movie6.setTrailerURL("https://www.youtube.com/watch?v=MFWF9dU5Zc0");
        movie7.setTrailerURL("https://www.youtube.com/watch?v=zSWdZVtXT7E");
        movie8.setTrailerURL("https://www.youtube.com/watch?v=ue80QwXMRHg");
        movie9.setTrailerURL("https://www.youtube.com/watch?v=dWUnYMggxy4");

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
