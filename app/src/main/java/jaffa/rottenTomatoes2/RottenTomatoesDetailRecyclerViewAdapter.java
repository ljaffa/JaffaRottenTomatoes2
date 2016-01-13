package jaffa.rottenTomatoes2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by libby on 1/10/2016.
 */
public class RottenTomatoesDetailRecyclerViewAdapter extends RecyclerView.Adapter<RottenTomatoesDetailViewHolder>{

    private Movie[] movies;

    public RottenTomatoesDetailRecyclerViewAdapter(Movie[] movies) {
        this.movies = movies;
    }


    @Override
    public RottenTomatoesDetailViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_pager_item, viewGroup, false);

        return new RottenTomatoesDetailViewHolder(itemView, viewGroup.getContext());

    }

    @Override
    public void onBindViewHolder(final RottenTomatoesDetailViewHolder holder, final int position) {
        holder.bind(movies[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("MOVIES", movies);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }
}
