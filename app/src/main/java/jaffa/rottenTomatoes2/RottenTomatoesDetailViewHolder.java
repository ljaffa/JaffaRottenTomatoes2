package jaffa.rottenTomatoes2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by libby on 1/10/2016.
 */
public class RottenTomatoesDetailViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private TextView title;
    private TextView criticsScore;
    private TextView audienceScore;
    private TextView synopsis;
    private TextView rating;
    private TextView runtime;
    private TextView releaseDate;
    private ImageView image;

    public RottenTomatoesDetailViewHolder(View itemView, Context context) {
        super(itemView);

        this.context = context;

        title = (TextView) itemView.findViewById(R.id.detailTitle);
        criticsScore = (TextView) itemView.findViewById(R.id.detailCriticsScore);
        audienceScore = (TextView) itemView.findViewById(R.id.detailAudienceScore);
        synopsis = (TextView) itemView.findViewById(R.id.detailSynopsis);
        rating = (TextView) itemView.findViewById(R.id.detailRating);
        runtime =(TextView) itemView.findViewById(R.id.detailRuntime);
        releaseDate = (TextView) itemView.findViewById(R.id.detailReleaseDate);
        image = (ImageView) itemView.findViewById(R.id.detailImage);
    }

    public void bind(Movie movie){
        title.setText(movie.getTitle());
        criticsScore.setText("Critics Score: " + movie.getRatings().getCritics_score() + "%");
        audienceScore.setText("Audience" +
                "Score: " + movie.getRatings().getAudience_score() + "%");
        synopsis.setText(movie.getSynopsis());
        rating.setText("Rated: " + movie.getMpaa_rating());
        runtime.setText("Running Time: " + movie.getRuntime());
        releaseDate.setText("Theater Release Date: " + movie.getReleaseDate().getTheater());

        Picasso.with(context).load(movie.getPosters().getOriginal())
                .into(image);
    }
}
