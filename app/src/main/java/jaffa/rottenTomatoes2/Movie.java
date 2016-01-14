package jaffa.rottenTomatoes2;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by libby on 1/5/2016.
 */
public class Movie implements Serializable {

    private String title;
    private String mpaa_rating;
    private String runtime;
    private String synopsis;
    private Poster posters;
    private ReleaseDate release_dates;
    private Rating ratings;
    private AbridgedCast[] abridgedCast;

    public String getTitle() {
        return title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Poster getPosters() {
        return posters;
    }

    public ReleaseDate getReleaseDate(){
        return release_dates;
    }

    public Rating getRatings() {
        return ratings;
    }

    public AbridgedCast[] getAbridgedCast() {
        return abridgedCast;
    }
}
