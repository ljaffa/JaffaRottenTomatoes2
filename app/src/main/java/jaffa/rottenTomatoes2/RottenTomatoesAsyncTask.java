package jaffa.rottenTomatoes2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by libby on 1/6/2016.
 */
public class RottenTomatoesAsyncTask extends AsyncTask<Long, Void, CurrentUpcoming> {

    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private BoxOfficeMovie currentMovies;
    private UpcomingMovies upcomingMovies;
    private OnMovieSelectedListener listener;
    private Context context;
    private CurrentUpcoming movies;

    public RottenTomatoesAsyncTask(ViewPager viewPager, Context context){
        this.viewPager = viewPager;
        this.currentMovies = null;
        this.upcomingMovies = null;
        this.context = context;
    }

    @Override
    protected CurrentUpcoming doInBackground(Long... params) {
        URL url = null;
        currentMovies = null;
        upcomingMovies = null;
        try {
            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=cart6246nbex6fqchrj5t4b8&limit=20");
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = null;
            in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            GsonBuilder builder = new GsonBuilder();
            builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            Gson gson = builder.create();
            currentMovies = gson.fromJson(reader, BoxOfficeMovie.class);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try {
            url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/upcoming.json?apikey=cart6246nbex6fqchrj5t4b8&limit=20");
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            InputStream in = null;
            in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            GsonBuilder builder = new GsonBuilder();
            builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            Gson gson = builder.create();
            upcomingMovies = gson.fromJson(reader, UpcomingMovies.class);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        movies = new CurrentUpcoming(currentMovies, upcomingMovies);
        return movies;
    }

    /*what to do when the AsyncTask completes
    * gets called on the UIThread. all text views can only be modified on the UIThread*/

    protected void onPostExecute(CurrentUpcoming movies) {

        super.onPostExecute(movies);

        Movie[] currentMovies = movies.getCurrentMovies().getMovies();
        Movie[] upcomingMovies = movies.getUpcomingMovies().getMovies();

        RottenTomatoesMainPagerAdapter pagerAdapter = new RottenTomatoesMainPagerAdapter(currentMovies, upcomingMovies, context);
        viewPager.setAdapter(pagerAdapter);
    }
}

