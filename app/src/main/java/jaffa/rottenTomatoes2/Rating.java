package jaffa.rottenTomatoes2;

import java.io.Serializable;

/**
 * Created by libby on 1/7/2016.
 */
public class Rating implements Serializable {


    private int critics_score;
    private int audience_score;

    public int getAudience_score() {
        return audience_score;
    }

    public int getCritics_score() {

        return critics_score;
    }
}
