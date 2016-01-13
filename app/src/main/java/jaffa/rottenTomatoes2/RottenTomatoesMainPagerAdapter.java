package jaffa.rottenTomatoes2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by libby on 1/10/2016.
 */
public class RottenTomatoesMainPagerAdapter extends PagerAdapter{

    /*private TextView title;
    private ImageView image;
    private TextView scores;
    private TextView castList;
    private TextView ratingRuntime;
    private Context context;*/

    private Movie[] currentMovies;
    private Movie[] upcomingMovies;
    private int position;
    private Context context;

    public RottenTomatoesMainPagerAdapter(Movie[] currentMovies, Movie[] upcomingMovies, Context context){
        this.currentMovies = currentMovies;
        this.upcomingMovies = upcomingMovies;
        this.position = position;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /*public void bind(Movie movie){
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


    }*/

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.upcoming_movie_list_item, null);

        /*TextView title = (TextView) view.findViewById(R.id.title);
        ImageView image = (ImageView) view.findViewById(R.id.posterImage);
        TextView scores = (TextView) view.findViewById(R.id.scores);
        TextView castList = (TextView) view.findViewById(R.id.cast);
        TextView ratingRuntime = (TextView) view.findViewById(R.id.ratingRuntime);*/

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        if (position == 0) {
            Movie[] movie = currentMovies;
            RottenTomatoesRecyclerViewAdapter adapter = new RottenTomatoesRecyclerViewAdapter(currentMovies);
            recyclerView.setAdapter(adapter);
        }
        if (position == 1){
            Movie[] movie = upcomingMovies;
            RottenTomatoesRecyclerViewAdapter adapter = new RottenTomatoesRecyclerViewAdapter(upcomingMovies);
            recyclerView.setAdapter(adapter);
        }

        /*title.setText(movie.getTitle());
        scores.setText(String.valueOf(movie.getRatings().getCritics_score()) + "%   "
                + String.valueOf(movie.getRatings().getAudience_score()) + "%");
        for (AbridgedCast c : movie.getAbridgedCast()) {
            castList.append(c.getName() + ", ");
        }
        ratingRuntime.setText(movie.getMpaa_rating() + ", " + String.valueOf(movie.getRuntime()));

        Picasso.with(context).load(movie.getPosters().getThumbnail())
                .placeholder(R.drawable.small_movie_poster)
                .into(image);*/

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
