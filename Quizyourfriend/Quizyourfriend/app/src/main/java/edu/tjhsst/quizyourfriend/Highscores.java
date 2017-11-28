package edu.tjhsst.quizyourfriend;

import android.support.annotation.NonNull;

/**
 * Created by tianf on 10/24/2017.
 */

public class Highscores implements Comparable {
    private String name1;
    private String name2;
    private double score;

    public Highscores(double s, String o, String t) {
        score = s;
        name1 = o;
        name2 = t;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double compareTo(Highscores comparestu) {
        double compare = ((Highscores) comparestu).getScore();
        /* For Ascending order*/
        return this.score - compare;

    }

    public String toString(){
        return "" + name1 + " and " + name2 + " with " + score + " points.";
    }

    @Override
    public int compareTo(@NonNull Object o) {
        int compare = (int)((Highscores) o).getScore();
        /* For Ascending order*/
        return (int)this.score - compare;
    }
}
