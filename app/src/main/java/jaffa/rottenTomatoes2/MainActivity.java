package jaffa.rottenTomatoes2;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements OnMovieSelectedListener {
        //, OnTabSelectedListener{

   /* private RecyclerView recyclerView;*/
    private ViewPager viewPager;
    private TabLayout tabLayout;
    TabLayout.OnTabSelectedListener tabListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recyclerView = (RecyclerView) findViewById(R.id.listViewMovies);*/
        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Now Playing"));
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));

        /*tabLayout.setOnTabSelectedListener(tabListener);*/
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(tabListener);

        /*tabLayout.setupWithViewPager(viewPager);*/

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);*/

        /*RottenTomatoesMainPagerAdapter adapter = new RottenTomatoesMainPagerAdapter
                ( this);
        viewPager.setAdapter(adapter);*/

        RottenTomatoesAsyncTask task = new RottenTomatoesAsyncTask(viewPager, this);
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener tabListener){
        this.tabListener = tabListener;
    }*/

    @Override
    public void onSelect(BoxOfficeMovie movies, int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("MOVIES", movies.getMovies());
        intent.putExtra("POSITION", position);
        this.startActivity(intent);
    }

    /*@Override
    public void onSelectTab(UpcomingMovies movies) {
        Intent intent = new Intent(this, UpcomingActivity.class);
        intent.putExtra("MOVIES", movies.getMovies());
        this.startActivity(intent);
    }*/
}
