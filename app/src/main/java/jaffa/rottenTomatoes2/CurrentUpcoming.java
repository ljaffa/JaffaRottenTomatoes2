package jaffa.rottenTomatoes2;

/**
 * Created by libby on 1/12/2016.
 */
public class CurrentUpcoming {

    private UpcomingMovies upcomingMovies;
    private BoxOfficeMovie currentMovies;

    public CurrentUpcoming(BoxOfficeMovie currentMovies, UpcomingMovies upcomingMovies) {
        this.upcomingMovies = upcomingMovies;
        this.currentMovies = currentMovies;
    }

    public UpcomingMovies getUpcomingMovies() {
        return upcomingMovies;
    }

    public BoxOfficeMovie getCurrentMovies() {
        return currentMovies;
    }


}
