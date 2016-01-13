package jaffa.rottenTomatoes2;

import java.io.Serializable;

/**
 * Created by libby on 1/10/2016.
 */
public class Poster implements Serializable{

    private String thumbnail;
    private String profile;
    private String detailed;
    private String original;

    public String getThumbnail(){
        return thumbnail;
    }

    public String getProfile(){
        return profile;
    }

    public String getDetailed(){
        return detailed;
    }

    public String getOriginal(){
        return original;
    }

}
