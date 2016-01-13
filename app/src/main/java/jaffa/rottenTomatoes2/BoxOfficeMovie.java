package jaffa.rottenTomatoes2;

import java.io.Serializable;

/**
 * Created by libby on 1/7/2016.
 */
public class BoxOfficeMovie implements Serializable{

    private Movie[] movies;

    public Movie[] getMovies(){
        return movies;
    }
}
