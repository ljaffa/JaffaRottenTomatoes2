package jaffa.rottenTomatoes2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by libby on 1/5/2016.
 */
public class BoxOfficeMoviesAdapter extends ArrayAdapter<Movie>{

    public BoxOfficeMoviesAdapter(Context context, ArrayList<Movie> aMovies){
        super(context, 0, aMovies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_box_office_movie, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView criticsScore = (TextView) convertView.findViewById(R.id.criticsScore);
        TextView cast = (TextView) convertView.findViewById(R.id.cast);
        ImageView posterImage = (ImageView) convertView.findViewById(R.id.posterImage);

        title.setText(movie.getTitle());
        criticsScore.setText("Score: " + movie.getRatings().getCritics_score() + "%");
        cast.setText(movie.getAbridgedCast()[0].getName());
        Picasso.with(getContext()).load(movie.getPosters().getProfile()).into(posterImage);

        return convertView;
    }

}
