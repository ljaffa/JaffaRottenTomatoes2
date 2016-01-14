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

    private Movie[] currentMovies;
    private Movie[] upcomingMovies;
    private int position;
    private Context context;

    public RottenTomatoesMainPagerAdapter(Movie[] currentMovies, Movie[] upcomingMovies, Context context){
        this.currentMovies = currentMovies;
        this.upcomingMovies = upcomingMovies;
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

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.upcoming_movie_list_item, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        if (position == 0) {
            RottenTomatoesRecyclerViewAdapter adapter = new RottenTomatoesRecyclerViewAdapter(currentMovies);
            recyclerView.setAdapter(adapter);
        }
        if (position == 1){
            RottenTomatoesRecyclerViewAdapter adapter = new RottenTomatoesRecyclerViewAdapter(upcomingMovies);
            recyclerView.setAdapter(adapter);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
