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
    private TextView castList;
    private TextView ratingRuntime;
    private Context context;

    public RottenTomatoesViewHolder(View itemView, Context context){
       super(itemView);

        this.context = context;

        title = (TextView) itemView.findViewById(R.id.title);
        image = (ImageView) itemView.findViewById(R.id.posterImage);
        scores = (TextView) itemView.findViewById(R.id.scores);
         castList = (TextView) itemView.findViewById(R.id.cast);
        ratingRuntime = (TextView) itemView.findViewById(R.id.ratingRuntime);
       }

    public void bind(Movie movie){
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


    }


}
