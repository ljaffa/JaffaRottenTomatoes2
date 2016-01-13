package jaffa.rottenTomatoes2;

import java.io.Serializable;

/**
 * Created by libby on 1/10/2016.
 */
public class UpcomingMovies implements Serializable{

    private Movie[] movies;

    public Movie[] getMovies(){
        return movies;
    }

}
