package jaffa.rottenTomatoes2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by libby on 1/7/2016.
 */
public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Movie[] movies = (Movie[]) getIntent().getSerializableExtra("MOVIES");
        int position = getIntent().getIntExtra("POSITION", 0);

        RottenTomatoesPagerAdapter adapter = new RottenTomatoesPagerAdapter(movies, position, this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

        RottenTomatoesDetailRecyclerViewAdapter detailAdapter =
                new RottenTomatoesDetailRecyclerViewAdapter(movies);
        recyclerView.setAdapter(detailAdapter);

    }


}
