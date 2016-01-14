package jaffa.rottenTomatoes2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by libby on 1/7/2016.
 */
public class RottenTomatoesViewHolder extends RecyclerView.ViewHolder{

    private TextView title;
    private ImageView image;
    private TextView scores;
    private TextView criticsScore;
    private TextView audienceScore;
    private ImageView criticsImage;
    private ImageView audienceImage;
    private TextView castList;
    private TextView ratingRuntime;
    private Context context;

    public RottenTomatoesViewHolder(View itemView, Context context){
       super(itemView);

        this.context = context;

        title = (TextView) itemView.findViewById(R.id.title);
        image = (ImageView) itemView.findViewById(R.id.posterImage);
        criticsScore = (TextView) itemView.findViewById(R.id.criticsScore);
        audienceScore = (TextView) itemView.findViewById(R.id.audienceScore);
        criticsImage = (ImageView) itemView.findViewById(R.id.criticsImage);
        audienceImage = (ImageView) itemView.findViewById(R.id.audienceImage);
        castList = (TextView) itemView.findViewById(R.id.cast);
        ratingRuntime = (TextView) itemView.findViewById(R.id.ratingRuntime);
       }

    public void bind(Movie movie){
        title.setText(movie.getTitle());
        if (movie.getRatings().getCritics_score() > 0) {
            criticsScore.setText(String.valueOf(movie.getRatings().getCritics_score()) + "%");
            criticsImage.setImageResource(R.drawable.critics_score);
        }
        audienceScore.setText(String.valueOf(movie.getRatings().getAudience_score()) + "%");
        audienceImage.setImageResource(R.drawable.audience_score);
        AbridgedCast[] list = movie.getAbridgedCast();
         for (int i = 0; i < list.length; i++) {
            castList.append(list[i].getName() + ", ");
        }
        ratingRuntime.setText(movie.getMpaa_rating() + ", " + String.valueOf(movie.getRuntime()));

        Picasso.with(context).load(movie.getPosters().getThumbnail())
                .placeholder(R.drawable.small_movie_poster)
                .into(image);

    }


}
