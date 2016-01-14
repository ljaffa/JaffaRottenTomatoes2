package jaffa.rottenTomatoes2;

import java.io.Serializable;

/**
 * Created by libby on 1/7/2016.
 */
public class AbridgedCast implements Serializable{

    private String name;

    public String getName(){
        return name;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name + " ");
        return builder.toString();
    }


}
