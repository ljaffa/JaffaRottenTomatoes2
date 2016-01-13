package jaffa.rottenTomatoes2;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by libby on 1/8/2016.
 */
public class RottenTomatoesPagerAdapter extends PagerAdapter {

    private Movie[] movies;
    private int position;
    private Context context;

    public RottenTomatoesPagerAdapter(Movie[] movies, int position, Context context){
        this.movies = movies;
        this.position = position;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    /*@Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.activity_main, null);

        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView image = (ImageView) view.findViewById(R.id.posterImage);
        TextView scores = (TextView) view.findViewById(R.id.scores);
        TextView castList = (TextView) view.findViewById(R.id.cast);
        TextView ratingRuntime = (TextView) view.findViewById(R.id.ratingRuntime);

        Movie movie = movies[position];
        title.setText(movie.getTitle());
        scores.setText(String.valueOf(movie.getRatings().getCritics_score()) + "%   "
                + String.valueOf(movie.getRatings().getAudience_score()) + "%");
        for (AbridgedCast c : movie.getAbridgedCast()) {
            castList.append(c.getName() + ", ");
        }
        ratingRuntime.setText(movie.getMpaa_rating() + ", " + String.valueOf(movie.getRuntime()));

        Picasso.with(context).load(movie.getPosters().getThumbnail())
                .placeholder(R.drawable.small_movie_poster)
                .into(image);

        container.addView(view);
        return view;
    }*/

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.movie_pager_item, null);

        TextView title = (TextView) view.findViewById(R.id.detailTitle);
        TextView criticsScore = (TextView) view.findViewById(R.id.detailCriticsScore);
        TextView audienceScore = (TextView) view.findViewById(R.id.detailAudienceScore);
        TextView synopsis = (TextView) view.findViewById(R.id.detailSynopsis);
        TextView rating = (TextView) view.findViewById(R.id.detailRating);
        TextView runtime =(TextView) view.findViewById(R.id.detailRuntime);
        TextView releaseDate = (TextView) view.findViewById(R.id.detailReleaseDate);
        ImageView image = (ImageView) view.findViewById(R.id.detailImage);
        ImageView image2 = (ImageView) view.findViewById(R.id.image2);

        Movie movie = movies[position];
        title.setText(movie.getTitle());
        title.setTextColor(Color.WHITE);
        criticsScore.setText("Critics Score: " + movie.getRatings().getCritics_score() + "%");
        audienceScore.setText("Audience" +
                "Score: " + movie.getRatings().getAudience_score() + "%");
        synopsis.setText(movie.getSynopsis());
        rating.setText("Rated: " + movie.getMpaa_rating());
        runtime.setText("Running Time: " + movie.getRuntime());
        releaseDate.setText("Theater Release Date: " + movie.getReleaseDate().getTheater());


        Picasso.with(context).load(movie.getPosters().getOriginal())
                .into(image);
        Picasso.with(context).load(movie.getPosters().getProfile()).into(image2);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
